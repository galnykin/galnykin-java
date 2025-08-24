package by.nsv.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public final class ElementUtils {
    private ElementUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static WebElement findElement(By locator) {
        return DriverManager.getDriver().findElement(locator);
    }

    public static WebElement findElement(WebElement parent, By locator) {
        return parent.findElement(locator);
    }

    public static List<WebElement> findElements(By locator) {
        return DriverManager.getDriver().findElements(locator);
    }

    public static List<WebElement> findElements(WebElement parent, By locator) {
        return parent.findElements(locator);
    }

    public static void click(By locator) {
        findElement(locator).click();
    }

    public static void sendKeys(By locator, String value) {
        findElement(locator).sendKeys(value);
    }

    public static void clearAndSendKeys(By locator, String value) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    public static String getText(By locator) {
        return findElement(locator).getText();
    }

    public static boolean isDisplayed(By locator) {
        try {
            return findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
