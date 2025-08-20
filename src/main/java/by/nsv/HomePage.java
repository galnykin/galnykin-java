package by.nsv;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;

    private final String BASE_URL = "https://nsv.by/";

    private final By AUTH_LINK = By.xpath("//header//a[@data-name='auth']");
    private final By AUTH_FORM = By.xpath("//div[contains(@class,'auth_frame')]");

    private final By ACCEPT_ALL_COOKIES_BUTTON = By.xpath("//a[@id='paloma_cookie-accept']");
    private final By COOKIES_BLOCK = By.xpath("//div[@class='paloma_cookie-block']");

    private final By CLOSE_MODAL_GAME_BANNER = By.xpath("//div[@class='modal_game_width_close']");
    private final By GAME_BANNER = By.xpath("//div[@class='modal_game_width_block']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openSite() {
        driver.navigate().to(BASE_URL);
    }

    public void acceptAllCookiesIfVisible() {
        if (isCookiesBannerVisible()) {
            clickAcceptAllCookiesButton();
        }
    }

    public void closeGameBannerIfVisible() {
//        waitUntilGameBannerIsClickable(Duration.ofSeconds(6));
        if (isGameBannerVisible()) {
            clickCloseGameBanner();
        }
    }

    private void waitUntilElementClickable(By locator, Duration timeout) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    private void clickElement(By xpath) {
        driver.findElement(xpath).click();
    }

    private boolean isElementVisible(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private void waitUntilElementDisappears(By locator, Duration timeout) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public boolean isAuthFormVisible() {
        return isElementVisible(AUTH_FORM);
    }

    public void waitUntilFormIsVisible(Duration timeout) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.elementToBeClickable(AUTH_FORM));
    }

    public void waitUntilAuthLinkIsClickable(Duration timeout) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.elementToBeClickable(AUTH_LINK));
    }

    public void clickAuthLink() {
        clickElement(AUTH_LINK);
    }

    public void clickAcceptAllCookiesButton() {
//        waitUntilElementClickable(ACCEPT_ALL_COOKIES_BUTTON, Duration.ofSeconds(6));
        clickElement(ACCEPT_ALL_COOKIES_BUTTON);
    }

    public boolean isCookiesBannerVisible() {
        return isElementVisible(COOKIES_BLOCK);
    }

    public void waitUntilGameBannerIsClickable(Duration timeout) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.elementToBeClickable(GAME_BANNER));
    }

    public void waitUntilCookiesBannerDisappears(Duration timeout) {
        waitUntilElementDisappears(ACCEPT_ALL_COOKIES_BUTTON, timeout);
    }

    public boolean isGameBannerVisible() {
        return isElementVisible(GAME_BANNER);
    }

    public void waitUntilGameBannerDisappears(Duration timeout) {
        waitUntilElementDisappears(GAME_BANNER, timeout);
    }

    public void clickCloseGameBanner() {
//        waitUntilElementClickable(CLOSE_MODAL_GAME_BANNER, Duration.ofSeconds(6));
        clickElement(CLOSE_MODAL_GAME_BANNER);
    }
}
