package by.teachmeskills.page;

import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class NewProjectPage {
    private static final By PROJECT_NAME = By.id("project-name");
    private static final By PROJECT_CODE = By.id("project-code");
    private static final By DESCRIPTION = By.id("description-area");
    private static final By PRIVATE_ACCESS = By.xpath("//span[text()='Private']");
    private static final By PUBLIC_ACCESS = By.xpath("//span[text()='Public']");
    private static final By ADD_ALL_MEMBERS = By.xpath("//span[text()='Add all members to this project']");
    private static final By ADD_MEMBERS_FROM_GROUP = By.xpath("//span[text()='Add members from specific group']");
    private static final By DO_NOT_ADD_MEMBERS = By.xpath("//span[text()='Don't add members']");
    private static final By CANCEL = By.xpath("//span[text()='Cancel']");
    private static final By CREATE_PROJECT = By.xpath("//span[text()='Create project']");
    private static final By TITLE = By.xpath("//h3[text()='Create new project']");
    private static final By CLOSE_ICON = By.xpath("//button [@class='wm4NvL Vb722t']");

    public boolean isOpened() {
        return $(TITLE).isDisplayed();
    }

    public NewProjectPage enterProjectName(String projectName) {
        $(PROJECT_NAME).shouldBe(visible, enabled).sendKeys(projectName);
        return this;
    }

    public ProjectDetailsPage clickCreateProject() {
        $(CREATE_PROJECT).shouldBe(visible, enabled).click();
        return new ProjectDetailsPage();
    }

    public ProjectsPage clickCloseIcon() {
        $(CLOSE_ICON).shouldBe(enabled).click();
        return new ProjectsPage();
    }

    public NewProjectPage choosePublicAccess() {
        $(PUBLIC_ACCESS).click();
        return this;
    }
}
