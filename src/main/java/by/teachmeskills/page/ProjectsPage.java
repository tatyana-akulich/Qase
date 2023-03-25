package by.teachmeskills.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class ProjectsPage extends Header {
    private final static By CREATE_NEW_PROJECT = By.xpath("//span[text() = 'Create new project']");
    private final static By TITLE = By.xpath("//h1 [text() = 'Projects']");
    private final static String ITEM_RIGHT_MENU = "//a[text()='%s']/ancestor::tr//a[@class='btn btn-dropdown']";
    private final static String ITEM_DELETE = "//a[text()='%s']/ancestor::tr//button[text()='Delete']";
    private final static By ALL_PROJECTS = By.xpath("//a[@class='defect-title']");
    private final static By CONFIRM_DELETE_PROJECT = By.xpath("//span[text()='Delete project']");
    private final static String DELETE_CONFIRMATION_MESSAGE = "//small[contains (text(), 'Are you sure, that you want delete project \"%s\"')]";

    public NewProjectPage clickCreateNewProject() {
        $(CREATE_NEW_PROJECT).shouldBe(visible, enabled).click();
        return new NewProjectPage();
    }

    public boolean isOpened() {
        $(TITLE).shouldBe(visible, Duration.ofSeconds(5));
        return $(TITLE).isDisplayed();
    }

    public ProjectsPage clickRightMenuForProject(String projectName) {
        $(By.xpath(String.format(ITEM_RIGHT_MENU, projectName))).shouldBe(visible, enabled).click();
        return this;
    }

    public ProjectsPage clickDeleteProject(String projectName) {
        $(By.xpath(String.format(ITEM_DELETE, projectName))).shouldBe(visible, enabled).click();
        return this;
    }

    public ProjectsPage clickConfirmDelete (){
        $(CONFIRM_DELETE_PROJECT).shouldBe(visible, enabled).click();
        return this;
    }

    public boolean deleteMessageContainsProjectName (String projectName){
        return $(By.xpath(String.format(DELETE_CONFIRMATION_MESSAGE, projectName))).isDisplayed();
    }

    public List<String> getProjectsList() {
        $(ALL_PROJECTS).shouldBe(visible, Duration.ofSeconds(15));
        return $$(ALL_PROJECTS).texts();
    }
}
