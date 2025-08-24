package by.nsv;

import by.nsv.pages.HomePage;
import by.nsv.webdriver.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

    protected HomePage homePage;

    @BeforeEach
    public void setUpBase() {
        homePage = new HomePage();
        homePage.openSite();
        customizeSetup();
    }

    protected void customizeSetup() {
        homePage.clickCloseGameBanner()
                .clickAcceptAllCookiesButton();
    }

    @AfterEach
    public void closeBrowser() {
        DriverManager.quit();
    }
}
