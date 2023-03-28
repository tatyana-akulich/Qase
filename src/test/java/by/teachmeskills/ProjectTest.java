package by.teachmeskills;

import by.teachmeskills.dto.AccessType;
import by.teachmeskills.dto.Project;
import by.teachmeskills.page.Header;
import by.teachmeskills.page.NewProjectPage;
import by.teachmeskills.page.ProjectDetailsPage;
import by.teachmeskills.page.ProjectsPage;
import by.teachmeskills.step.LoginSteps;
import by.teachmeskills.step.ProjectSteps;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProjectTest {
    private Faker faker = new Faker();
    private Project newProject;

    @Test
    public void createProjectWithObligatoryFields() {
        new LoginSteps().loginWithValidCredentials().clickCreateNewProject();
        NewProjectPage newProjectPage = new NewProjectPage();

        assertThat(newProjectPage.isOpened())
                .as("Modal window for creating new project should be opened")
                .isTrue();
        newProjectPage.clickCloseIcon();

        newProject = Project.builder()
                .projectName(faker.name().name())
                .build();

        String projectName = newProject.getProjectName();
        new ProjectSteps().createProjectOnlyWithName(projectName);
        assertThat(new ProjectDetailsPage().isOpenedWithCreatedProject(projectName))
                .as("Project details page should be opened for project with chosen name")
                .isTrue();

        ProjectsPage projectsPage = new Header().openProjectsPage();
        assertThat(projectsPage.isOpened())
                .as("Projects page should be opened")
                .isTrue();

        assertThat(projectsPage.getProjectsList())
                .as("Projects list shouldn't be empty")
                .isNotEmpty();

        assertThat(projectsPage.getProjectsList())
                .as("Project name should be in the list of projects")
                .contains(projectName);
        projectsPage.signOut();
    }

    @Test
    public void createDeletePublicProject() {
        new LoginSteps().loginWithValidCredentials();

        newProject = Project.builder()
                .projectName(faker.name().name())
                .type(AccessType.PUBLIC)
                .build();
        String projectName = newProject.getProjectName();

        ProjectSteps projectSteps = new ProjectSteps();
        projectSteps.createPublicProject(projectName);
        assertThat(projectSteps.getProjectInfo())
                .as("Data entered during creating project should be displayed correctly on projectDetailsPage")
                .isEqualTo(newProject);

        ProjectsPage projectsPage = new Header().openProjectsPage();
        assertThat(projectsPage.getProjectsList())
                .as("Project name should be in the list of projects")
                .contains(projectName);

        projectSteps.deleteProject(projectName);
        assertThat(projectsPage.deleteMessageContainsProjectName(projectName))
                .as("Message with name of project for removal should be displayed")
                .isTrue();

        projectsPage = new Header().openProjectsPage();
        assertThat(projectsPage.getProjectsList())
                .as("Name of deleted project should not be in the list of projects")
                .doesNotContain(projectName);
        projectsPage.signOut();
    }
}
