package by.nsv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class AuthFormTest extends BaseTest {

    HomePage homePage;
    AuthForm authForm;

    @BeforeEach
    public void setUpPreLoginState() {
        homePage = new HomePage(driver);
        authForm = new AuthForm(driver);

        homePage.openSite();
        homePage.acceptAllCookiesIfVisible();
        homePage.closeGameBannerIfVisible();
        homePage.waitUntilAuthLinkIsClickable(Duration.ofSeconds(2));
        homePage.clickAuthLink();
    }

    @Test
    @DisplayName("Текст заголовка формы авторизации")
    public void testLoginFormTitleText() {
        Assertions.assertEquals("Личный кабинет", authForm.getAuthFormTitleText(),
                "Неверный заголовок формы логина");
    }

    @Test
    @DisplayName("Сообщение об ошибке при пустом логине и пароле")
    public void testBlankLoginAndPasswordShowErrorMessages() {
        authForm.clickLoginButton();

        String expectedErrorMessage = "Заполните это поле";
        Assertions.assertEquals(expectedErrorMessage, authForm.getUserLoginPopupErrorMessage(),
                "Неверное сообщение об ошибке для логина");
        Assertions.assertEquals(expectedErrorMessage, authForm.getUserPasswordPopupErrorMessage(),
                "Неверное сообщение об ошибке для пароля");
    }

    @Test
    @DisplayName("Сообщение об ошибке при пустом логине")
    public void testBlankLoginShowsErrorMessage() {
        // Arrange
        String validPassword = "validPassword";
        String expectedErrorMessage = "Заполните это поле";

        // Act
        authForm.inputPassword(validPassword);
        authForm.clickLoginButton();

        // Assert
        String actualErrorMessage = authForm.getUserLoginPopupErrorMessage();
        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage,
                "Неверное сообщение об ошибке при пустом логине");
    }

    @Test
    @DisplayName("Сообщение об ошибке при пустом пароле")
    void testBlankPasswordShowsErrorMessage() {
        // Arrange
        String validLogin = "validLogin";
        String expectedErrorMessage = "Заполните это поле";

        // Act
        authForm.inputLogin(validLogin);
        authForm.clickLoginButton();

        // Assert
        String actualErrorMessage = authForm.getUserPasswordPopupErrorMessage();
        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage,
                "Ожидалось сообщение об ошибке при пустом пароле");
    }

    @Test
    @DisplayName("Сообщение об ошибке при вводе короткого пароля")
    void testShortPasswordShowErrorMessage() {
        // Arrange
        String shortPassword = "1";
        String expectedErrorMessage = "Минимум 6 символов";

        // Act
        authForm.inputPassword(shortPassword);
        authForm.clickLoginButton();

        // Assert
        String actualErrorMessage = authForm.getUserPasswordPopupErrorMessage();
        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage,
                "Сообщение об ошибке для пароля не соответствует ожидаемому");
    }

    @Test
    @DisplayName("Сообщение об ошибке при вводе неверного логина с корректным паролем")
    void testInvalidLoginShowsErrorMessage() {
        // Arrange
        String invalidLogin = "1";
        String validPassword = "validPassword";
        String expectedErrorMessage = "Неверный логин или пароль";

        // Act
        authForm.inputLogin(invalidLogin);
        authForm.inputPassword(validPassword);
        authForm.clickLoginButton();

        // Assert
        String actualErrorMessage = authForm.getAlertDangerMessage();
        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage,
                "Сообщение об ошибке не соответствует ожидаемому");
    }
}
