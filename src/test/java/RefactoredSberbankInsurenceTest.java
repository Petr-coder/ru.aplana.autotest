import org.junit.Test;
import pages.MainPage;
import pages.TravelersInsurancePage;

public class RefactoredSberbankInsurenceTest extends BaseTest {

    @Test
    public void newInsuranceTest() throws InterruptedException {
        driver.get(baseUrl + "/");
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Страхование путешественников");

        new TravelersInsurancePage(driver).waitSendAppClickable();

    }
}
