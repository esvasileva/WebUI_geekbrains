package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookieWindow extends BasePage {

    public CookieWindow(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookieAcceptButton;

    @Step("Accept cookie")
    public void acceptCookie() {
        cookieAcceptButton.click();
    }
}
