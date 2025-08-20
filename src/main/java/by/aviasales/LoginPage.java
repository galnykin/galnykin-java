package by.aviasales;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;

    // Page URLs
    private static final String BASE_URL = "https://www.aviasales.by/";

    // Locators
    private final By buttonProfile = By.xpath("//button[@data-test-id='profile-button']");
    private final By buttonLogin = By.xpath("//button[@data-test-id='login-button']");

    private final By titleLoginForm = By.xpath("//h2[@data-test-id='text' " +
            "and contains(@class, 's__iJBMZitzwvgbRTkV')]");

    private final By descriptionLoginForm = By.xpath("//p[@data-test-id='text' " +
            "and @class='s__n2GvXvgb2QAtHwtC s__KBmaRkw4Ac86ZK9H s__Deb1FZmxbB4lzYZJ']");

    private final By buttonMoreWays = By.xpath("//button[@data-test-id='button' " +
            "and @class = 's__xTbFkBFZyBAINZxE s__xQ1HLgn_xwmIN8uv s__XsmUYZQtxJYdQBOo" +
            " s__x18IUVOhPRYBssUO s__R4Y0HS8AyNExntlT s__hEzBUXqAxp4rGvuo']");

    private final By buttonAppleLogin = By.xpath("//button[@data-test-id='method-button-apple']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openSite() {
        driver.get(BASE_URL);
    }

    public void clickButton(By buttonLocator) {
        WebElement buttonProfile = driver.findElement(buttonLocator);
        buttonProfile.click();
    }

    public void clickProfileButton() {
        clickButton(buttonProfile);
    }

    public void clickLoginButton() {
        clickButton(buttonLogin);
    }

    public void clickMoreWaysButton() {
        clickButton(buttonMoreWays);
    }

    public void clickAppleLoginButton() {
        clickButton(buttonAppleLogin);
    }

    public String getLoginFormTitle() {
        WebElement titleAccountForm = driver.findElement(titleLoginForm);
        return titleAccountForm.getText();
    }

    public String getLoginFormDescription() {
        WebElement descriptionAccountForm = driver.findElement(descriptionLoginForm);
        return descriptionAccountForm.getText();
    }
}
