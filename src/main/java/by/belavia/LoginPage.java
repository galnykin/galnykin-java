package by.belavia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final String URL = "https://belavia.by/";
    private WebDriver driver;
    private final String LINK_ACCOUNT = "//a[@id='ffp-account']";
    private final String TITLE_ACCOUNT_FORM = "//div[@class='title-2IBhr']";
    private final String TEXT_ACCOUNT_FORM = "//div[@class='text-3uUxD']";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLinkAccount() {
        WebElement linkAccount = driver.findElement(By.xpath(LINK_ACCOUNT));
        linkAccount.click();
    }

    public String getTitleAccountFormText() {
        WebElement titleAccountForm = driver.findElement(By.xpath(TITLE_ACCOUNT_FORM));
        return titleAccountForm.getText();
    }

    public String getTextAccountFormText() {
        WebElement textAccountForm = driver.findElement(By.xpath(TEXT_ACCOUNT_FORM));
        return textAccountForm.getText();
    }

    public void openSite() {
        driver.get(URL);
    }
}
