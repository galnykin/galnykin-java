package by.dodopizza;

public class LoginPageLocator {
    public static final String H3_PROVIDE_A_PHONE =
            "//div[@class='popup-inner sc-17puf9f-0 dyohjW']//h3[contains(text(), 'Укажите телефон')]";
    public static final String LABEL_PHONE_NUMBER =
            "//label[@for='phn-input']//span[contains(text(), 'Номер телефона')]";
    public static final String INPUT_PHONE_INPUT =
            "//input[@id='phn-input']";
    public static final String BUTTON_LOGIN_SUBMIT_BUTTON =
            "//button[@data-testid='login_submit_button']";
    public static final String BUTTON_POPUP_CLOSE_BUTTON =
            "//button[@class='popup-close-button']";
}
