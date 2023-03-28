package by.teachmeskills.step;

import by.teachmeskills.dto.AccessType;
import by.teachmeskills.dto.Project;
import by.teachmeskills.page.ProjectDetailsPage;
import by.teachmeskills.page.ProjectsPage;

public class ProjectSteps {
    private ProjectsPage projectsPage;
    private ProjectDetailsPage projectDetailsPage;

    public ProjectSteps() {
        this.projectsPage = new ProjectsPage();
        this.projectDetailsPage = new ProjectDetailsPage();
    }

    public ProjectDetailsPage createProjectOnlyWithName(String projectName) {
        return projectsPage.clickCreateNewProject().enterProjectName(projectName).clickCreateProject();
    }

    public ProjectDetailsPage createPublicProject(String projectName) {
        return projectsPage.clickCreateNewProject().enterProjectName(projectName).choosePublicAccess().clickCreateProject();
    }

    public ProjectsPage deleteProject(String projectName) {
        return projectsPage.clickRightMenuForProject(projectName).clickDeleteProject(projectName).clickConfirmDelete();
    }

    public Project getProjectInfo() {
        AccessType type;
        if (projectDetailsPage.isPublic()) {
            type = AccessType.PUBLIC;
        } else {
            type = AccessType.PRIVATE;
        }

        return Project.builder()
                .projectName(projectDetailsPage.getProjectName())
                .description(projectDetailsPage.getProjectDescription())
                .type(type)
                .build();
    }


}
