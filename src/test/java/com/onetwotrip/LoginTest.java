package com.onetwotrip;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {
    WebDriver webDriver;

    @BeforeEach
    public void setup() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    @Test
    @DisplayName("Проверка формы логина")
    public void test1() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openSite();
        loginPage.clickLinkButtonAccount();
        loginPage.getTitleAccountFormText();
        loginPage.getTextAccountFormText();

        Assertions.assertEquals("Вход в личный кабинет", loginPage.getTitleAccountFormText());
        Assertions.assertEquals("Войдите с помощью социальной сети или используйте электронную почту.",
                loginPage.getTextAccountFormText());
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }
}
