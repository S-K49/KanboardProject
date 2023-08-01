package ui.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginElements extends AbstractPageObject{

    public SelenideElement userField() {
        return $("#form-username");
    }

    public SelenideElement passwordField() {
        return $("#form-password");
    }

    public SelenideElement submitButton() {
        return $x("//button[@type='submit']");
    }

    public SelenideElement errorMessage() {
        return $(".alert");
    }

    public SelenideElement captcha() {
        return $(".Captcha");
    }

    public SelenideElement forgotPassword() {
        return $(".reset-password");
    }
}
