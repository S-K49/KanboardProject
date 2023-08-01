package ui.tests;

import api.steps.UserApiSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import ui.steps.LoginPage;

public class LoginTests extends BaseTest {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    private static final String INVALID_CRED = "admin123";

    private static final String ERROR_MESSAGE = "Bad username or password";

    UserApiSteps userApiSteps = new UserApiSteps();

    private String userId;

//    @BeforeMethod
//    public void setUpDataForTest() {
//        userId = userApiSteps.createUser(USERNAME, PASSWORD);
//    }
//
    @BeforeMethod
    public void login() {
        new LoginPage()
                .openLoginPage();
    }

    @Test
    public void loginByNewUser() {
        new LoginPage()
                .loginByUser(USERNAME, PASSWORD)
                .assertMainSectionIsOpened()
                .logout();
    }

    @Test
    public void loginInvalidPassword() {
        new LoginPage()
                .loginWithInvalidCreds(USERNAME, INVALID_CRED)
                .assertInvalidCredentiials(ERROR_MESSAGE);
    }

    @Test
    public void validateRequiredFields() {
        new LoginPage()
                .validateEmptyFields()
                .validatePassword(USERNAME)
                .validateUsername(PASSWORD);
    }

    @Test
    public void loginInvalidUser() {
        new LoginPage()
                .loginWithInvalidCreds(INVALID_CRED, PASSWORD)
                .assertInvalidCredentiials(ERROR_MESSAGE);

    }


//    @AfterMethod(alwaysRun = true)
//    public void removeUserAfterTest() {
//        userApiSteps.deleteUser(Integer.valueOf(userId));
//    }
}
