package by.teachmeskills;

import by.teachmeskills.page.Header;
import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.ProjectsPage;
import by.teachmeskills.step.LoginSteps;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest {
    @Test
    public void loginAsValidUser() {
        new LoginSteps().loginWithValidCredentials();

        assertThat(new ProjectsPage().isOpened())
                .as("After entering valid credentials Projects page should be opened")
                .isTrue();

        new Header().signOut();
    }

    @Test
    public void loginWithEmptyValues() {
        new LoginSteps().login("", "");

        assertThat(new LoginPage().isValidationMessageShown())
                .as("Validation message should be shown if login or password is invalid")
                .isTrue();

        assertThat(new ProjectsPage().isOpened())
                .as("After entering wrong credentials Projects page should not be opened")
                .isFalse();
    }

    @Test
    public void loginWithValidEmail() {
        new LoginPage().openPage().enterValidEmail().enterPassword("").clickLogin();

        assertThat(new LoginPage().isValidationMessageShown())
                .as("Validation message should be shown if login or password is invalid")
                .isTrue();
    }
}
