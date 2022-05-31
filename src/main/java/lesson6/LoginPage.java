package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "signInEmail")
    private WebElement emailField;

    @FindBy(id = "signInPassword")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()=\"Login\"]")
    private WebElement loginButton;

    @Step("Login via TAO")
    public void login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
