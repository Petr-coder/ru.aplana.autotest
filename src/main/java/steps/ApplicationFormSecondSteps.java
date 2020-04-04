package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ApplicationFormSecondPage;

import java.util.Map;


public class ApplicationFormSecondSteps {

    @When("^Заполняются поля:$")
    public void stepFillFields(DataTable fields) {
        Map<String, String> dataMap = fields.asMap(String.class, String.class);
        dataMap.forEach(
                (key, value) -> new ApplicationFormSecondPage().fillField(key, value));
    }



    @Then("^Проверяются поля$")
    public  void stepCheckFileFields(DataTable fields){
        Map<String, String> dataMap = fields.asMap(String.class, String.class);
        dataMap.forEach(
                (key, value) -> new ApplicationFormSecondPage().checkFillField(key,value));
    }

    @When("^Выполнено нажатие на кнопку Продолжить$")
    public void waitContinueButtonClick() {
        new ApplicationFormSecondPage().waitContinueButton();
    }

    @Then("^Выполнена проверка появления сообщения \"(.*)\"$")
    public void checkErrorMessageField(String value) {
        new ApplicationFormSecondPage().checkFieldErrorMessage(value);
    }

}
