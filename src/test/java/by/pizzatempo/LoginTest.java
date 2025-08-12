package by.pizzatempo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    WebDriver driver;

    @BeforeEach
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.pizzatempo.by/");
    }

    @Test
    public void test1() {
        By inputLoginByXpath = By.xpath(LoginPage.INPUT_LOGIN);
        WebElement inputLoginElement = driver.findElement(inputLoginByXpath);
        inputLoginElement.sendKeys("John Black");

        By inputPasswordByXpath = By.xpath(LoginPage.INPUT_PASSWORD);
        WebElement inputPasswordElement = driver.findElement(inputPasswordByXpath);
        inputPasswordElement.sendKeys("12345weew");

        By buttonSubmitByXpath = By.xpath(LoginPage.BUTTON_SUBMIT);
        WebElement buttonSubmitElement = driver.findElement(buttonSubmitByXpath);
        buttonSubmitElement.click();

        By messageByXpath = By.xpath(LoginPage.MESSAGE_PATH);
        WebElement messageElement = driver.findElement(messageByXpath);
        String actual = messageElement.getText();
        Assertions.assertEquals("Неверно указано имя пользователя или пароль.\n" +
                "Ok", actual);
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }
}
