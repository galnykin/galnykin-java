package com.onetwotrip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final String URL = "https://www.onetwotrip.com/ru-by/";
    private WebDriver webDriver;

    private final String LINK_BUTTON_ACCOUNT = "//button[@data-locator='Button profileLogin']";
    private final String TITLE_ACCOUNT_FORM = "//div[@data-locator='ModalContent title']";
    private final String TEXT_ACCOUNT_FORM = "//div[@class='iRYgN']";

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openSite() {
        webDriver.get(URL);
    }

    public void clickLinkButtonAccount() {
        WebElement linkButtonAccount = webDriver.findElement(By.xpath(LINK_BUTTON_ACCOUNT));
        linkButtonAccount.click();
    }

    public String getTitleAccountFormText() {
        WebElement titleAccountForm = webDriver.findElement(By.xpath(TITLE_ACCOUNT_FORM));
        return titleAccountForm.getText();
    }

    public String getTextAccountFormText() {
        WebElement textAccountForm = webDriver.findElement(By.xpath(TEXT_ACCOUNT_FORM));
        return textAccountForm.getText();
    }
}
