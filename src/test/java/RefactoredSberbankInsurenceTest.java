import org.junit.Test;
import pages.ApplicationFormFirstPage;
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
        applicationFormFirstPage.waitInsuranceCoverAmount();

    }
}
