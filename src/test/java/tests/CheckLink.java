package tests;
//возможность перехода на главную страницу яндекса и сервиса

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import utils.BaseTest;

public class CheckLink extends BaseTest {
    @Test //Тестируем переход на страницу яндекса(дзен)
    public void testGoToYandex() {
        Assert.assertTrue(new HomePage(driver)
                .goToYandexHomePageClick()
                .isYandexPageOpen());
    }


    @Test //Тестируем на главную страницу самоката.
    public void testGoToScooterServiceHomePage() {
        Assert.assertTrue(new HomePage(driver)
                .btnRentScooterTopClick() //Уходим на страницу с заказом
                .goToScooterHomePage()
                .getScooterHomePageWelcomeText()); //Проверяем, текст на главной странице виден.
    }


}
