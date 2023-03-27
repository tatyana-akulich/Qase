package by.teachmeskills;

import by.teachmeskills.page.LoginPage;
import by.teachmeskills.step.LoginSteps;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SignOutTest {
    @Test
    public void signOut (){
        new LoginSteps().loginWithValidCredentials().signOut();
        assertThat(new LoginPage().isOpened())
                .as("After sign out Login page should be opened")
                .isTrue();
    }
}
