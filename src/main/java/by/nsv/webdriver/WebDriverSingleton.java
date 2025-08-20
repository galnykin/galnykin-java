package by.nsv.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverSingleton {
    private static WebDriver driver;

//    private Singleton() {
//
//    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        }
        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebElement findElement(By locator) {
        return getDriver().findElement(locator);
    }

    public static void clickElement(By locator) {
        getDriver().findElement(locator).click();
    }

    public static void sendKeysToElement(By locator, String value) {
        getDriver().findElement(locator).sendKeys(value);
    }

    public static String getTextFromElement(By locator) {
        return getDriver().findElement(locator).getText();
    }

    public static boolean isElementVisible(By locator) {
        try {
            return WebDriverSingleton.isElementVisible(locator);
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
