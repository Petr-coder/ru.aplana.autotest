package steps;

import io.cucumber.java.en.When;
import pages.ApplicationFormFirstPage;

public class ApplicationFormFirstSteps  {

    @When("^Выбрана сумма страховой защиты \"(.*)\"$")
    public void stepWaitInsuranceCoverAmount(String menuItem){
        new ApplicationFormFirstPage().waitInsuranceCoverAmount(menuItem);
    }

    @When("^Выполнено нажатие на кнопку \"(.*)\"$")
    public void stepWaitMakeOnlineApplication(String menuItem) {
        new ApplicationFormFirstPage().waitMakeOnlineApplication(menuItem);
    }

}
