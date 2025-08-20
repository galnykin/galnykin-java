package by.nsv;

import by.nsv.webdriver.WebDriverSingleton;
import org.junit.jupiter.api.AfterEach;

public abstract class BaseTest {

    @AfterEach
    public void closeBrowser() throws InterruptedException {
        WebDriverSingleton.quit();
    }
}
