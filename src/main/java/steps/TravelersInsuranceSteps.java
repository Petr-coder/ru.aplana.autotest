package steps;

import io.cucumber.java.en.When;
import pages.TravelersInsurancePage;

import static util.DriverManager.getDriver;

public class TravelersInsuranceSteps  {

    @When("^Выполнено нажатие на кнопку Оформить онлайн$")
    public void stepSendAppButton() {
        new TravelersInsurancePage(getDriver()).waitSendAppClickable();
    }
}
