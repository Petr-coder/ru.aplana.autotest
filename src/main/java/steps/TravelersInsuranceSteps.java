package steps;

import io.qameta.allure.Step;
import pages.TravelersInsurancePage;


public class TravelersInsuranceSteps extends BaseSteps {

    @Step("нажатие на кнопку - Оформить онлайн")
    public void stepSendAppButton() {
        new TravelersInsurancePage(driver).waitSendAppClickable();
    }
}
