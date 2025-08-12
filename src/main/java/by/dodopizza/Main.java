package by.dodopizza;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.pizzatempo.by/");
//      driver.get("https://dodopizza.by/");
//      String xpathRegistration = "//a[@href='https://www.pizzatempo.by/registration/']";

        String inputLoginXpath = "//input[@name='astroauth_login']";
//      By byXpath = By.xpath(xpathRegistration);
        By inputLoginByXpath = By.xpath(inputLoginXpath);
        WebElement inputLoginElement = driver.findElement(inputLoginByXpath);
        inputLoginElement.sendKeys("John");

        String inputPasswordXpath = "//input[@name='astroauth_pass']";
        By inputPasswordByXpath = By.xpath(inputPasswordXpath);
        WebElement inputPasswordElement = driver.findElement(inputPasswordByXpath);
        inputPasswordElement.sendKeys("12345weew");

        String xpathSubmit = "//input[@name='astroauth_submit']";
        By inputSubmitByXpath = By.xpath(xpathSubmit);
        WebElement inputSubmitElement = driver.findElement(inputSubmitByXpath);
        inputSubmitElement.click();

        String messageXpath = "//div[@class='popupContent']";
        By messageByXpath = By.xpath(messageXpath);
        WebElement messageElement = driver.findElement(messageByXpath);
        String actual = messageElement.getText();
        System.out.println(actual);
        Assertions.assertEquals("Неверно указано имя пользователя или пароль.\n" +
                "Ok", actual);
    }
}
