package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lesson7.CustomLogger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

@Epic("Login via TAO")
public class TaoSignIn {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
        driver.get("https://www.t-a-o.com/en/login");
        new CookieWindow(driver).acceptCookie();
    }

    @Test
    @Feature("Авторизация на сайте TAO")
    @Story("Авторизация с невалидными данными")
    void signInInvalid() {
        new LoginPage(driver).login("test@test.ru", "password123");
        Assertions.assertTrue(new ErrorSignIn(driver)
                                  .waitFormError()
                                  .formError
                                  .isDisplayed()
        );
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
