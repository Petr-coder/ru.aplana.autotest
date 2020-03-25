package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import pages.ApplicationFormFirstPage;


import java.util.HashMap;

public class ApplicationFormFirstSteps extends BaseSteps {

    @Step("выбирается поле {0}")
    public void stepWaitInsuranceCoverAmount(String field){
        new ApplicationFormFirstPage().waitInsuranceCoverAmount(field);
    }

    @Step("выбирается поле {0}")
    public void stepWaitMakeOnlineApplication(String field){
        new ApplicationFormFirstPage().waitMakeOnlineApplication(field);
    }

}
