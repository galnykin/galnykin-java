package by.nsv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class HomePageTest extends BaseTest {

    HomePage homePage;

    @BeforeEach
    public void setUpHomePage() {
        homePage = new HomePage(driver);
        homePage.openSite();
    }

    @Test
    @DisplayName("Баннер cookies отображается при загрузке страницы")
    void testCookiesBannerIsVisibleOnLoad() {
        Assertions.assertTrue(homePage.isCookiesBannerVisible(),
                "Баннер cookies должен быть видим при загрузке страницы");
    }

    @Test
    @DisplayName("Баннер cookies исчезает после принятия всех cookies")
    void testCookiesBannerDisappearsAfterAcceptAllCookies() {
        Assertions.assertTrue(homePage.isCookiesBannerVisible(),
                "Перед принятием всех cookies баннер должен быть видим");

        homePage.clickAcceptAllCookiesButton();
//        homePage.waitUntilCookiesBannerDisappears(Duration.ofSeconds(2));

        Assertions.assertFalse(homePage.isCookiesBannerVisible(),
                "После принятия всех cookies баннер должен исчезнуть");
    }

    @Test
    @DisplayName("Баннер игры отображается на главной странице")
    void testGameBannerIsVisible() {
//        homePage.waitUntilGameBannerIsClickable(Duration.ofSeconds(7));
        Assertions.assertTrue(homePage.isGameBannerVisible(),
                "Баннер должен быть видим при загрузке страницы");
    }

    @Test
    @DisplayName("Баннер игры закрывается при клике")
    void testGameBannerCanBeClosed() {
//        testGameBannerIsVisible();
        homePage.clickCloseGameBanner();
//        homePage.waitUntilGameBannerDisappears(Duration.ofSeconds(2));
        Assertions.assertFalse(homePage.isGameBannerVisible(),
                "Баннер должен исчезнуть после закрытия");
    }

    @Test
    @DisplayName("Проверка отображения формы авторизации")
    void testClickAuthLink() {
        homePage.closeGameBannerIfVisible();
        homePage.acceptAllCookiesIfVisible();
        homePage.waitUntilAuthLinkIsClickable(Duration.ofSeconds(2));

        homePage.clickAuthLink();
        Assertions.assertTrue(homePage.isAuthFormVisible(),
                "После перехода по ссылке авторизации должна отображаться форма авторизации");
    }
}
