package by.belavia;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;

    @Test
    public void test1() {
        String url = "https://belavia.by/";
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.manage().window().maximize();
        driver.navigate().to(url);

        final String LINK_ACCOUNT = "//a[@id='ffp-account']";
        WebElement linkAccount = driver.findElement(By.xpath(LINK_ACCOUNT));
        linkAccount.click();

        final String TITLE_ACCOUNT_FORM = "//div[@class='title-2IBhr']";
        WebElement titleAccountForm = driver.findElement(By.xpath(TITLE_ACCOUNT_FORM));
        String titleAccountFormText = titleAccountForm.getText();

        final String TEXT_ACCOUNT_FORM = "//div[@class='text-3uUxD']";
        WebElement textAccountForm = driver.findElement(By.xpath(TEXT_ACCOUNT_FORM));
        String textAccountFormText = textAccountForm.getText();

        Assertions.assertEquals("Вход", titleAccountFormText);
        Assertions.assertEquals(
                "Если у вас нет аккаунта — он создастся автоматически",
                textAccountFormText);

        driver.quit();
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    @Test
    public void test2() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openSite();
        loginPage.clickLinkAccount();

        Assertions.assertEquals("Вход", loginPage.getTitleAccountFormText());
        Assertions.assertEquals(
                "Если у вас нет аккаунта — он создастся автоматически",
                loginPage.getTextAccountFormText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
