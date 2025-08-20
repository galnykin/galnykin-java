package by.nsv.pages;

import by.nsv.webdriver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AuthForm {

    private final By AUTH_FORM_TITLE = By.xpath("//div[@class='form_head']/h2");
    private final By CLOSE_AUTH_FORM_BUTTON =
            By.xpath("//div[contains(@class,'auth_frame')]/a[@class='close jqmClose']");

    private final By USER_LOGIN_INPUT = By.cssSelector("#USER_LOGIN_POPUP");
    private final By USER_PASSWORD_INPUT = By.id("USER_PASSWORD_POPUP");
    private final By LOGIN_BUTTON = By.name("Login");

    private final By USER_LOGIN_POPUP_ERROR_ID = By.id("USER_LOGIN_POPUP-error");
    private final By USER_PASSWORD_POPUP_ERROR_ID = By.id("USER_PASSWORD_POPUP-error");
    private final By ALERT_DANDER_MESSAGE = By.xpath("//div[@class='alert alert-danger']/p");

    public String getAuthFormTitleText() {
        return WebDriverSingleton.getTextFromElement(AUTH_FORM_TITLE);
    }

    public void clickCloseAuthFormButton() {
        WebDriverSingleton.clickElement(CLOSE_AUTH_FORM_BUTTON);
    }

    public String getAlertDangerMessage() {
        return WebDriverSingleton.getTextFromElement(ALERT_DANDER_MESSAGE);
    }

    public void inputPassword(String password) {
        WebElement passwordInput = WebDriverSingleton.findElement(USER_PASSWORD_INPUT);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void inputLogin(String login) {
        WebElement loginInput = WebDriverSingleton.findElement(USER_LOGIN_INPUT);
        loginInput.clear();
        loginInput.sendKeys(login);
    }

    public void clickLoginButton() {
        WebDriverSingleton.clickElement(LOGIN_BUTTON);
    }

    public String getUserLoginPopupErrorMessage() {

        return WebDriverSingleton.getTextFromElement(USER_LOGIN_POPUP_ERROR_ID);
    }

    public String getUserPasswordPopupErrorMessage() {
        return WebDriverSingleton.getTextFromElement(USER_PASSWORD_POPUP_ERROR_ID);
    }
}
