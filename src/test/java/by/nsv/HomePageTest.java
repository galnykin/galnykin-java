package by.nsv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest extends BaseTest {

    @BeforeEach
    public void setUpHomePage() {
    }

    @Override
    protected void customizeSetup() {
    }

    @Test
    @DisplayName("Баннер cookies отображается при загрузке страницы")
    void testCookiesBannerIsVisibleOnLoad() {
        assertTrue(homePage.isCookiesBannerVisible(),
                "Баннер cookies должен быть видим при загрузке страницы");
    }

    @Test
    @DisplayName("Баннер cookies исчезает после принятия всех cookies")
    void testCookiesBannerDisappearsAfterAcceptAllCookies() {
        assertTrue(homePage.isCookiesBannerVisible(),
                "Перед принятием всех cookies баннер должен быть видим");

        homePage.clickAcceptAllCookiesButton();

        assertFalse(homePage.isCookiesBannerVisible(),
                "После принятия всех cookies баннер должен исчезнуть");
    }

    @Test
    @DisplayName("Баннер игры отображается на главной странице")
    void testGameBannerIsVisible() {
        assertTrue(homePage.isGameBannerVisible(),
                "Баннер должен быть видим при загрузке страницы");
    }

    @Test
    @DisplayName("Баннер игры закрывается при клике")
    void testGameBannerCanBeClosed() {
//        testGameBannerIsVisible();
        homePage.clickCloseGameBanner();
//        homePage.waitUntilGameBannerDisappears(Duration.ofSeconds(2));
        assertFalse(homePage.isGameBannerVisible(),
                "Баннер должен исчезнуть после закрытия");
    }

    @Test
    @DisplayName("Проверка отображения формы авторизации")
    void testClickAuthLink() {

        homePage.waitUntilAuthLinkIsClickable(Duration.ofSeconds(2))
                .clickAuthLink();

        assertTrue(homePage.isAuthFormVisible(),
                "После перехода по ссылке авторизации должна отображаться форма авторизации");
    }
}
