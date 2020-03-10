import org.junit.Test;
import pages.MainPage;

public class RefactoredSberbankInsurenceTest extends BaseTest {

    @Test
    public void newInsuranceTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Страхование путешественников");
    }
}
