package by.teachmeskills.page;

import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

public class Header {
    private static final By ICON_USER = By.xpath("//img[@class ='DmlkSu NMUwK0']");
    private static final By SIGN_OUT = By.xpath("//span[text()='Sign out']");
    private static final By MENU_PROJECTS = By.xpath("//a[text()='Projects']");

    public LoginPage signOut() {
        $(ICON_USER).shouldBe(enabled, Duration.ofSeconds(10)).click();
        $(SIGN_OUT).shouldBe(enabled, Duration.ofSeconds(10)).click();
        return new LoginPage();
    }

    public ProjectsPage openProjectsPage() {
        $(MENU_PROJECTS).click();
        return new ProjectsPage();
    }
}
