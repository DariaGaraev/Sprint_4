package config;

public class TestConfig {
    //Переменная выбора браузера
    public static final TargetBrowserEnum TARGET_BROWSER = TargetBrowserEnum.CHROME;
    //public static final TargetBrowserEnum TARGET_BROWSER =TargetBrowserEnum.FIREFOX;
    public static final Integer IMPLICIT_WAIT_SECONDS = 10;     //Таймаут WEB драйвера
    public static final Integer INCORRECT_ORDER_NUMBER = 42;    //Номер несуществующего заказа
}
