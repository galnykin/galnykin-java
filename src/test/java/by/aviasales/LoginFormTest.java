package by.aviasales;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginFormTest {
    private WebDriver driver;
    private LoginForm loginForm;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        loginForm = new LoginForm(driver);
        loginForm.openSite();
    }

    @Test
    @DisplayName("Проверка открытия формы логина")
    public void testLoginFormOpening() {
        loginForm.clickProfileButton();
        loginForm.clickLoginButton();
    }

    @Test
    @DisplayName("Проверка заголовка формы логина")
    public void testLoginFormTitle() {
        loginForm.clickProfileButton();
        loginForm.clickLoginButton();

        Assertions.assertEquals("Войдите в профиль",
                loginForm.getLoginFormTitle(),
                "Неверный заголовок формы логина");
    }

    @Test
    @DisplayName("Проверка описания формы логина")
    public void testLoginFormDescription() {
        loginForm.clickProfileButton();
        loginForm.clickLoginButton();

        Assertions.assertEquals("Чтобы обращаться в поддержку и следить за ценами на нужные билеты",
                loginForm.getLoginFormDescription(),
                "Неверное описание формы логина");
    }

    @Test
    @DisplayName("Проверка дополнительных способов входа")
    public void testAdditionalLoginMethods() {
        loginForm.clickProfileButton();
        loginForm.clickLoginButton();
        loginForm.clickMoreWaysButton();
    }

    @Test
    @DisplayName("Проверка входа через Apple")
    public void testAppleLogin() {
        loginForm.clickProfileButton();
        loginForm.clickLoginButton();
        loginForm.clickMoreWaysButton();
        loginForm.clickAppleLoginButton();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
