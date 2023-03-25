package by.teachmeskills.page;

import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProjectDetailsPage {
    private static final By TITLE = By.xpath("//div[@class='sqabXr']");

    public boolean isOpenedWithCreatedProject(String projectName) {
        return $(TITLE).shouldBe(visible, Duration.ofSeconds(5)).getText().contains(projectName);
    }
}
