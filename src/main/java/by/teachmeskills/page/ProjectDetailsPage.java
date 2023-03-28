package by.teachmeskills.page;

import com.codeborne.selenide.conditions.Attribute;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProjectDetailsPage {
    private static final By TITLE = By.xpath("//div[@class='sqabXr']");
    private static final By SETTINGS = By.xpath("//span[text()='Settings']");
    private static final By PROJECT_NAME = By.id("project-name");
    private static final By PROJECT_CODE = By.id("project-code");
    private static final By PROJECT_DESCRIPTION = By.id("description-area");
    private static final By PUBLIC_RADIO = By.xpath("//input[@value='public']");


    public boolean isOpenedWithCreatedProject(String projectName) {
        return $(TITLE).shouldBe(visible, Duration.ofSeconds(5)).getText().contains(projectName);
    }

    public ProjectDetailsPage openSettings(){
        $(SETTINGS).shouldBe(enabled).click();
        return this;
    }

    public String getProjectName (){
        return $(PROJECT_NAME).shouldBe(visible).getValue();
    }

    public String getProjectCode (){
        return $(PROJECT_CODE).shouldBe(visible).getValue();
    }

    public String getProjectDescription (){
        String description = $(PROJECT_DESCRIPTION).shouldBe(visible).getText();
        if(description.isEmpty()){
            return null;
        } else return description;
    }

    public boolean isPublic(){
        return $(PUBLIC_RADIO).isSelected();
    }
}
