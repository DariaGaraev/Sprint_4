package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.HomePage;
import utils.BaseTest;
import utils.WebTestUtils;

@RunWith(Parameterized.class)
public class CreateNewRentalTest extends BaseTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String subwayStation;
    private final String phoneNumber;
    private final String dateStartRent;
    private final String rentPeriod;
    private final String colorScooter;
    private final String comment;

    public CreateNewRentalTest(String name, String surname, String address, String subwayStation, String phoneNumber,
                               String dateStartRent, String rentPeriod, String colorScooter, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phoneNumber = phoneNumber;
        this.dateStartRent = dateStartRent;
        this.rentPeriod = rentPeriod;
        this.colorScooter = colorScooter;
        this.comment = comment;
    }

    @Parameterized.Parameters()
    public static Object[][] getTestDate() {
        return new Object[][]{
                {"Иван", "Епиванцев", "ул. Садовая, дом 13", "Митино", "+777766457852", WebTestUtils.getDateForTest(0),
                        "четверо суток", "чёрный жемчуг", "Побыстреее"},
                {"Вениамин", "Витоминов", "ул. Ситцевая, дом 17к2", "Театральная", "+75123456789",
                        WebTestUtils.getDateForTest(10), "двое суток", "серая безысходность", "к парковке за домом"}
        };
    }

    //Проверяем позитивный сценарий заказа.
    // При проверке через Chrome возникнет ошибка - не появляется окно с подтверждением заказа
    @Test
    public void createNewRental() {
        //Проверяем возможность перехода к форме заказа через кнопку "заказать"
        Assert.assertTrue(new HomePage(driver)
                .btnRentScooterButtonClick()
                .isPageHeader());
    }
   @Test
    public void createFillRental() {

        //Возвращаемся на главную страницу и заполняем заказ через верхнюю кнопку
        Assert.assertTrue(new HomePage(driver)
                .goToScooterHomePage()
                .btnRentScooterTopClick()
                .addCustomerInfo(name, surname, address, subwayStation, phoneNumber)
                .addRentInfo(dateStartRent, rentPeriod, colorScooter, comment)
                .btnConfirmNewRentClick()
                .isPageRentConfirmed());
    }


}
