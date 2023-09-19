package tests;

import config.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import utils.BaseTest;

public class CheckIncorrectOrderTest extends BaseTest {


    @Test //проверка  правильности номера заказа, будет выведена страница с сообщение "Такого заказа нет"
    public void checkIncorrectOrder() {
        Assert.assertTrue(new HomePage(driver)
                .btnSwitchToCheckRentStatusClick()
                .setOrderNum(TestConfig.INCORRECT_ORDER_NUMBER.toString())
                .btnCheckRentStatus()
                .isTrackNoFound());
    }


}
