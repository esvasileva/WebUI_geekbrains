package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginPage {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.t-a-o.com/en/login");

        WebElement acceptAllCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptAllCookies.click();

        WebElement emailField = driver.findElement(By.id("signInEmail"));
        emailField.sendKeys("test@test.ru");

        WebElement passwordFields = driver.findElement(By.id("signInPassword"));
        passwordFields.sendKeys("password123");

        WebElement loginButton = driver.findElement(By.xpath("//button[text()=\"Login\"]"));
        loginButton.click();

        driver.quit();
    }
}
