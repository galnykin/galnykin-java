package by.nsv.pages;

import by.nsv.webdriver.DriverManager;
import by.nsv.webdriver.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final String BASE_URL = "https://nsv.by/";

    private final By AUTH_LINK = By.xpath("//header//a[@data-name='auth']");
    private final By AUTH_FORM = By.xpath("//div[contains(@class,'auth_frame')]");

    private final By ACCEPT_ALL_COOKIES_BUTTON = By.xpath("//a[@id='paloma_cookie-accept']");
    private final By COOKIES_BLOCK = By.xpath("//div[@class='paloma_cookie-block']");

    private final By CLOSE_MODAL_GAME_BANNER = By.xpath("//div[@class='modal_game_width_close']");
    private final By GAME_BANNER = By.xpath("//div[@class='modal_game_width_block']");

    public void openSite() {
        DriverManager.getDriver().navigate().to(BASE_URL);
    }

    public HomePage clickCloseGameBanner() {
        try {
            click(CLOSE_MODAL_GAME_BANNER);
        } catch (Exception e) {
            System.out.println("Баннера не было, баннер не закрывался");
        }
        return this;
    }

    private void click(By locator) {
        ElementUtils.click(locator);
    }

    public HomePage waitUntilAuthLinkIsClickable(Duration timeout) {
        new WebDriverWait(DriverManager.getDriver(), timeout)
                .until(ExpectedConditions.elementToBeClickable(AUTH_LINK));
        return this;
    }

    public void clickAuthLink() {
        click(AUTH_LINK);
    }

    public HomePage clickAcceptAllCookiesButton() {
        click(ACCEPT_ALL_COOKIES_BUTTON);
        return this;
    }

    public boolean isCookiesBannerVisible() {
        return ElementUtils.isDisplayed(COOKIES_BLOCK);
    }

    public boolean isGameBannerVisible() {
        return ElementUtils.isDisplayed(GAME_BANNER);
    }

    public boolean isAuthFormVisible() {
        return ElementUtils.isDisplayed(AUTH_FORM);
    }
}
