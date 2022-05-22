package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.t-a-o.com/en/login");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @Test
    void invalidLogin() {
        driver.findElement(By.id("signInEmail")).sendKeys("test@test.ru");
        driver.findElement(By.id("signInPassword")).sendKeys("password123");
        driver.findElement(By.xpath("//button[text()=\"Login\"]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"Form-error\"]")));
        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class=\"Form-error\"]")).isDisplayed(), true);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
