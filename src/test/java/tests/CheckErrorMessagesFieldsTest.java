package tests;

import config.TestData;
import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.NewRentClientInfoPage;
import utils.BaseTest;

//Тест неверного заполнения полей форм заказа.
public class CheckErrorMessagesFieldsTest extends BaseTest {
    @Test
    public void testErrorInFields() {
        //Заполняем поля неверными значениями
        NewRentClientInfoPage clientInfoPage = new HomePage(driver)
                .btnRentScooterButtonClick()
                .inputName(TestData.INCORRECT_NAME)
                .inputSurname(TestData.INCORRECT_SURNAME)
                .inputAddress(TestData.INCORRECT_ADDRESS)
                .inputPhoneNumber(TestData.INCORRECT_PHONE_NUMBER)
                .inputSubwayStationClick("aaaa")
                .inputSubwayStationClick("aaaa");
        //Проверяем, что все ошибки видны
        Assert.assertTrue(clientInfoPage.isInputNameErrorMessage());
        Assert.assertTrue(clientInfoPage.isInputSurnameErrorMessage());
        Assert.assertTrue(clientInfoPage.isInputAddressErrorMessage());
        Assert.assertTrue(clientInfoPage.isInputPhoneNumberError());
    }

}
