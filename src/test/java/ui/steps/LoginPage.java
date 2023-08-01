package ui.steps;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.WebDriver;
import ui.elements.LoginElements;

import java.awt.font.ImageGraphicAttribute;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends LoginElements {

        public LoginPage openLoginPage() {
            open("http://localhost:80");
            return new LoginPage();
        }

        public MainPage loginByUser(String username, String password) {
            userField().shouldBe(visible).sendKeys(username);
            passwordField().sendKeys(password);
            submitButton().click();
            return new MainPage();
        }

    public LoginPage loginWithInvalidCreds(String username, String password) {
        userField().shouldBe(visible).sendKeys(username);
        passwordField().sendKeys(password);
        submitButton().click();
        return this;
    }

    public LoginPage validateEmptyFields() {
        submitButton().click();
        userField().getCssValue("opacity").equals("1");
        return this;
    }

    public LoginPage validatePassword(String username) {
        userField().shouldBe(visible).sendKeys(username);
        submitButton().click();
        passwordField().getCssValue("opacity").equals("1");
        userField().clear();
        return this;
    }

    public LoginPage validateUsername(String password) {
        passwordField().sendKeys(password);
        submitButton().click();
        userField().getCssValue("opacity").equals("1");
        passwordField().clear();
            return this;
    }

        public LoginPage assertInvalidCredentiials(String errorMessage) {
           errorMessage().shouldBe(visible).shouldHave(Condition.text(errorMessage));
//           .getText().matches(ERROR_MESSAGE)
//            errorMessage().getText().matches(ERROR_MESSAGE);
            return this;
        }

        public LoginPage captche() {
            forgotPassword().click();
            String image = String.valueOf(captcha());
            System.out.println(image);
            return this;
        }

}
