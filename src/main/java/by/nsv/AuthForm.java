package by.nsv;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthForm {
    private final WebDriver driver;

    private final By AUTH_FORM_TITLE = By.xpath("//div[@class='form_head']/h2");
    private final By CLOSE_AUTH_FORM_BUTTON =
            By.xpath("//div[contains(@class,'auth_frame')]/a[@class='close jqmClose']");

    private final By USER_LOGIN_INPUT = By.cssSelector("#USER_LOGIN_POPUP");
    private final By USER_PASSWORD_INPUT = By.id("USER_PASSWORD_POPUP");
    private final By LOGIN_BUTTON = By.name("Login");

    private final By USER_LOGIN_POPUP_ERROR_ID = By.id("USER_LOGIN_POPUP-error");
    private final By USER_PASSWORD_POPUP_ERROR_ID = By.id("USER_PASSWORD_POPUP-error");
    private final By ALERT_DANDER_MESSAGE = By.xpath("//div[@class='alert alert-danger']/p");

    public AuthForm(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAuthFormVisible() {
        try {
            return driver.findElement(AUTH_FORM_TITLE).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getAuthFormTitleText() {
        return driver.findElement(AUTH_FORM_TITLE).getText();
    }

    public void clickCloseAuthFormButton() {
        driver.findElement(CLOSE_AUTH_FORM_BUTTON).click();
    }

    public String getAlertDangerMessage() {
        return driver.findElement(ALERT_DANDER_MESSAGE).getText();
    }

    public void inputPassword(String password) {
        WebElement passwordInput = driver.findElement(USER_PASSWORD_INPUT);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void inputLogin(String login) {
        WebElement loginInput = driver.findElement(USER_LOGIN_INPUT);
        loginInput.clear();
        loginInput.sendKeys(login);
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getUserLoginPopupErrorMessage() {

        return driver.findElement(USER_LOGIN_POPUP_ERROR_ID).getText();
    }

    public String getUserPasswordPopupErrorMessage() {
        return driver.findElement(USER_PASSWORD_POPUP_ERROR_ID).getText();
    }
}
