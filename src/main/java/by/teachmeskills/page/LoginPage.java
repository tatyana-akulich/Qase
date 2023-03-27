package by.teachmeskills.page;

import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginPage {
    public LoginPage() {
    }

    private final static By EMAIL = By.id("inputEmail");
    private final static By PASSWORD = By.id("inputPassword");
    private final static By LOGIN_BUTTON = By.id("btnLogin");
    private static final By TITLE = By.id("Symbols");

    public LoginPage openPage() {
        open("/login");
        getWebDriver().manage().window().maximize();
        return this;
    }

    public boolean isOpened() {
        $(TITLE).shouldBe(visible, Duration.ofSeconds(5));
        return $(TITLE).isDisplayed();
    }

    public LoginPage enterValidEmail() {
        $(EMAIL).shouldBe(visible, enabled).sendKeys("t.n.akulich@gmail.com");
        return this;
    }

    public LoginPage enterValidPassword() {
        $(PASSWORD).shouldBe(visible, enabled).sendKeys("Bsu12Ehu15");
        return this;
    }

    public LoginPage enterEmail(String email) {
        $(EMAIL).shouldBe(visible, enabled).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        $(PASSWORD).shouldBe(visible, enabled).sendKeys(password);
        return this;
    }

    public ProjectsPage clickLogin() {
        $(LOGIN_BUTTON).click();
        return new ProjectsPage();
    }
}
