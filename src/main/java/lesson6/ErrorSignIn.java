package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ErrorSignIn extends BasePage {

    public ErrorSignIn(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class=\"Form-error\"]")
    public WebElement formError;

    @Step("Waiting error form")
    public ErrorSignIn waitFormError() {
        webDriverWait.until(ExpectedConditions.visibilityOf(formError));
        return new ErrorSignIn(driver);
    }
}
