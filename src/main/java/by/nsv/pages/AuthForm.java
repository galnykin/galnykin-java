package by.nsv.pages;

import by.nsv.webdriver.ElementUtils;
import org.openqa.selenium.By;

public class AuthForm {

    private final By AUTH_FORM_TITLE = By.xpath("//div[@class='form_head']/h2");
    private final By CLOSE_BUTTON =
            By.xpath("//div[contains(@class,'auth_frame')]/a[@class='close jqmClose']");
    private final By LOGIN_INPUT = By.cssSelector("#USER_LOGIN_POPUP");
    private final By PASSWORD_INPUT = By.id("USER_PASSWORD_POPUP");
    private final By LOGIN_BUTTON = By.name("Login");

    private final By LOGIN_ERROR_MESSAGE = By.id("USER_LOGIN_POPUP-error");
    private final By PASSWORD_ERROR_MESSAGE = By.id("USER_PASSWORD_POPUP-error");
    private final By ALERT_DANGER_MESSAGE = By.xpath("//div[@class='alert alert-danger']/p");

    public String getTitle() {
        return ElementUtils.getText(AUTH_FORM_TITLE);
    }

    public void clickCloseButton() {
        ElementUtils.click(CLOSE_BUTTON);
    }

    public void setLogin(String login) {
        ElementUtils.clearAndSendKeys(LOGIN_INPUT, login);
    }

    public void setPassword(String password) {
        ElementUtils.clearAndSendKeys(PASSWORD_INPUT, password);
    }

    public void clickLoginButton() {
        ElementUtils.click(LOGIN_BUTTON);
    }

    public String getLoginErrorMessage() {
        return ElementUtils.getText(LOGIN_ERROR_MESSAGE);
    }

    public String getPasswordErrorMessage() {
        return ElementUtils.getText(PASSWORD_ERROR_MESSAGE);
    }

    public String getAlertDangerMessage() {
        return ElementUtils.getText(ALERT_DANGER_MESSAGE);
    }
}
