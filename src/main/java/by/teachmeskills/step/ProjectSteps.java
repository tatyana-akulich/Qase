package by.teachmeskills.step;

import by.teachmeskills.page.ProjectDetailsPage;
import by.teachmeskills.page.ProjectsPage;

public class ProjectSteps {
    private ProjectsPage projectsPage;

    public ProjectSteps() {
        this.projectsPage = new ProjectsPage();
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


}
