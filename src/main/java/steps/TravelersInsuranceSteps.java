package steps;

import io.qameta.allure.Step;
import pages.TravelersInsurancePage;

import static util.DriverManager.getDriver;

public class TravelersInsuranceSteps  {

    @Step("нажатие на кнопку - Оформить онлайн")
    public void stepSendAppButton() {
        new TravelersInsurancePage(getDriver()).waitSendAppClickable();
    }


}
