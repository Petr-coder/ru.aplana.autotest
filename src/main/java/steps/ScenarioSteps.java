package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    TravelersInsuranceSteps travelersInsuranceSteps = new TravelersInsuranceSteps();
    ApplicationFormFirstSteps applicationFormFirstSteps = new ApplicationFormFirstSteps();
    ApplicationFormSecondSteps applicationFormSecondSteps = new ApplicationFormSecondSteps();


    @When("^Выбран пункт меню \"(.*)\"$")
    public void stepSelectMainMenu(String menuItem) {
        mainSteps.stepSelectMainMenu(menuItem);
    }

    @When("^Выбран вид страхования \"(.*)\"$")
    public void stepSelectTypeInsurance(String menuItem) throws InterruptedException {
        mainSteps.stepSelectSubMenu(menuItem);
    }

    @When("^Выполнено нажатие на кнопку - Оформить онлайн")
    public void stepSendAppButton(String menuItem) {
        travelersInsuranceSteps.stepSendAppButton();
    }

    @When("^Выбрана сумма страховой защиты \"(.*)\"$")
    public void stepWaitInsuranceCoverAmount(String menuItem) {
        applicationFormFirstSteps.stepWaitInsuranceCoverAmount(menuItem);
    }

    @When("^Выполнено нажатие на кнопку - Оформить")
    public void stepWaitMakeOnlineApplication(String menuItem) {
        applicationFormFirstSteps.stepWaitMakeOnlineApplication(menuItem);
    }

    @When("Заполняются поля:")
    public void stepFillFields(DataTable fields) {
        fields.asMap(String.class, String.class).forEach(
                (key, value) -> applicationFormSecondSteps.fillField(key, value));
    }

}
