package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookieWindow extends BasePage {

    public CookieWindow(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookieAcceptButton;

    public void acceptCookie() {
        cookieAcceptButton.click();
    }
}
