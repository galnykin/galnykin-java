package by.nsv;

import by.nsv.pages.AuthForm;
import by.nsv.utils.Passwords;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthFormTest extends BaseTest {

    AuthForm authForm;

    @BeforeEach
    public void setUpPreLoginState() {
        authForm = new AuthForm();
        homePage.waitUntilAuthLinkIsClickable(Duration.ofSeconds(2))
                .clickAuthLink();
    }

    @Nested
    class PositiveTests {

        @Test
        @DisplayName("Текст заголовка формы авторизации")
        public void testLoginFormTitleText() {
            assertEquals("Личный кабинет", authForm.getTitle(),
                    "Неверный заголовок формы логина");
        }
    }

    @Nested
    class NegativeTests {

        @Test
        @DisplayName("Сообщение об ошибке при пустом логине и пароле")
        public void testBlankLoginAndPasswordShowErrorMessages() {
            authForm.clickLoginButton();

            String expectedErrorMessage = "Заполните это поле";
            assertEquals(expectedErrorMessage, authForm.getLoginErrorMessage(),
                    "Неверное сообщение об ошибке для логина");
            assertEquals(expectedErrorMessage, authForm.getPasswordErrorMessage(),
                    "Неверное сообщение об ошибке для пароля");
        }

        @Test
        @DisplayName("Сообщение об ошибке при пустом логине")
        public void testBlankLoginShowsErrorMessage() {
            // Arrange
            String validPassword = "validPassword";
            String expectedErrorMessage = "Заполните это поле";

            // Act
            authForm.setPassword(validPassword);
            authForm.clickLoginButton();

            // Assert
            String actualErrorMessage = authForm.getLoginErrorMessage();
            assertEquals(expectedErrorMessage, actualErrorMessage,
                    "Неверное сообщение об ошибке при пустом логине");
        }

        @Test
        @DisplayName("Сообщение об ошибке при пустом пароле")
        void testBlankPasswordShowsErrorMessage() {
            // Arrange
            String validLogin = "validLogin";
            String expectedErrorMessage = "Заполните это поле";

            // Act
            authForm.setLogin(validLogin);
            authForm.clickLoginButton();

            // Assert
            String actualErrorMessage = authForm.getPasswordErrorMessage();
            assertEquals(expectedErrorMessage, actualErrorMessage,
                    "Ожидалось сообщение об ошибке при пустом пароле");
        }

        @Test
        @DisplayName("Сообщение об ошибке при вводе короткого пароля")
        void testShortPasswordShowErrorMessage() {
            // Arrange (given)
            String shortPassword = Passwords.generateRandomPassword(5);
            String expectedErrorMessage = "Минимум 6 символов";

            // Act (when)
            authForm.setPassword(shortPassword);
            authForm.clickLoginButton();

            // Assert (then)
            String actualErrorMessage = authForm.getPasswordErrorMessage();
            assertEquals(expectedErrorMessage, actualErrorMessage,
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
            authForm.setLogin(invalidLogin);
            authForm.setPassword(validPassword);
            authForm.clickLoginButton();

            // Assert
            String actualErrorMessage = authForm.getAlertDangerMessage();
            assertEquals(expectedErrorMessage, actualErrorMessage,
                    "Сообщение об ошибке не соответствует ожидаемому");
        }
    }
}
