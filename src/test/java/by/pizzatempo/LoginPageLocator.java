package by.pizzatempo;

public class LoginPageLocator {
    public static final String FORM_AUTH_TITLE_PERSONAL_CABINET =
            "//form[@class='auth']//div[contains(text(), 'Личный кабинет')]";
    public static final String INPUT_LOGIN =
            "//input[@name='astroauth_login']";
    public static final String INPUT_PASSWORD =
            "//input[@name='astroauth_pass']";
    public static final String FORM_AUTH_LINK_REGISTRATION =
            "//form[@class='auth']//a[@href='https://www.pizzatempo.by/registration/']";
    public static final String FORM_AUTH_LINK_FORGOT_PASSWORD =
            "//form[@class='auth']//a[@href='https://www.pizzatempo.by/registration/forgot/']";
}
