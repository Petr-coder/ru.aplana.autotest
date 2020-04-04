package steps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

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

    @When("^Выполнено нажатие на кнопку Оформить онлайн$")
    public void stepSendAppButton() {
        travelersInsuranceSteps.stepSendAppButton();
    }

    @When("^Выбрана сумма страховой защиты \"(.*)\"$")
    public void stepWaitInsuranceCoverAmount(String menuItem) {
        applicationFormFirstSteps.stepWaitInsuranceCoverAmount(menuItem);
    }

    @When("^Выполнено нажатие на кнопку \"(.*)\"$")
    public void stepWaitMakeOnlineApplication1(String menuItem) {
        applicationFormFirstSteps.stepWaitMakeOnlineApplication(menuItem);
    }

    @When("^Заполняются поля:$")
    public void stepFillFields(DataTable fields) {
        Map<String, String> dataMap = fields.asMap(String.class, String.class);
        dataMap.forEach(
                (key, value) -> applicationFormSecondSteps.fillField(key, value));
    }

    @Then("^Проверяются поля$")
    public  void stepCheckFileFields(DataTable fields){
        Map<String, String> dataMap = fields.asMap(String.class, String.class);
        dataMap.forEach(
                (key, value) -> applicationFormSecondSteps.checkFillField(key,value));
    }

    @When("^Выполнено нажатие на кнопку Продолжить")
    public void stepWaitContinueButton(){
        applicationFormSecondSteps.waitContinueButtonClick();
    }

    @Then("^Выполнена проверка появления сообщения \"(.*)\"$")
            public void stepCheckErrorMessageField(String value) {
        applicationFormSecondSteps.checkErrorMessageField(value);
    }
}
