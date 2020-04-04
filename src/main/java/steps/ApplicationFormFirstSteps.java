package steps;

import io.qameta.allure.Step;
import pages.ApplicationFormFirstPage;

public class ApplicationFormFirstSteps  {

    @Step("выбирается поле {0}")
    public void stepWaitInsuranceCoverAmount(String menuItem){
        new ApplicationFormFirstPage().waitInsuranceCoverAmount(menuItem);
    }

    @Step("выбирается поле {0}")
    public void stepWaitMakeOnlineApplication(String menuItem) {
        new ApplicationFormFirstPage().waitMakeOnlineApplication(menuItem);
    }

}
