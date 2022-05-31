package lesson7;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.ByteArrayInputStream;

public class CustomLogger implements WebDriverListener {


    public void beforeFindElement(WebDriver driver, By locator) {
        Allure.step("Ищем элемент по локатору" + locator.toString());
    }

    public void beforeQuit(WebDriver driver) {
        Allure.addAttachment("Скриншот перед поиском элемента",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

}
