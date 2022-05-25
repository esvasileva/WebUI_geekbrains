package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaoSignIn {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get("https://www.t-a-o.com/en/login");
        new CookieWindow(driver).acceptCookie();
    }

    @Test
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
