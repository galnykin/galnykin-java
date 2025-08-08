package by.pizzatempo;

public class LoginPageLocator {
    public static final String FORM_AUTH_PERSONAL_CABINET_TITLE =
            "//form[@class='auth']//div[contains(text(), 'Личный кабинет')]";
    public static final String INPUT_LOGIN =
            "//input[@name='astroauth_login']";
    public static final String INPUT_PASS =
            "//input[@name='astroauth_pass']";
    public static final String FORM_AUTH_REGISTRATION_LINK =
            "//form[@class='auth']//a[contains(text(), 'Регистрация')]";
    public static final String FORM_AUTH_FORGOT_PASSWORD_LINK =
            "//form[@class='auth']//a[contains(text(), 'Забыли пароль?')]";
}
