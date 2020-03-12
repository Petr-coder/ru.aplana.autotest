import org.junit.Test;
import pages.ApplicationFormFirstPage;
import pages.ApplicationFormSecondPage;
import pages.MainPage;
import pages.TravelersInsurancePage;

import static org.junit.Assert.assertTrue;

public class RefactoredSberbankInsurenceTest extends BaseTest {

    @Test
    public void newInsuranceTest() throws InterruptedException {
        driver.get(baseUrl + "/");
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Страхование путешественников");

        new TravelersInsurancePage(driver).waitSendAppClickable();

        ApplicationFormFirstPage applicationFormFirstPage = new ApplicationFormFirstPage(driver);
        String actualTitle = ApplicationFormFirstPage.titleOfApplicationSelectPolicy.getText();
        String expectedTitle = "Страхование путешественников";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));


        applicationFormFirstPage.waitInsuranceCoverAmount();
        applicationFormFirstPage.waitMakeOnlineApplication();

        ApplicationFormSecondPage applicationFormSecondPage = new ApplicationFormSecondPage(driver);
        applicationFormSecondPage.fillField("Фамилия /Surname", "Ivanov");
        applicationFormSecondPage.fillField("Имя / Given names", "Ivan");
        applicationFormSecondPage.fillField("birthDate_vzr_ins_0", "10101990");
        applicationFormSecondPage.fillField("Фамилия", "Иванов");
        applicationFormSecondPage.fillField("Имя", "Иван");
        applicationFormSecondPage.fillField("Отчество", "Иванович");
        applicationFormSecondPage.fillField("Дата рождения", "10101990");
        applicationFormSecondPage.fillField("passportSeries", "5220");
        applicationFormSecondPage.fillField("passportNumber", "363677");
        applicationFormSecondPage.fillField("Дата выдачи", "10102010");
        applicationFormSecondPage.fillField("Кем выдан", "ывапывап");
        applicationFormSecondPage.sendButton.click();


    }
}
