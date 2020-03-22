package steps;

import org.openqa.selenium.WebElement;
import pages.ApplicationFormFirstPage;
import pages.ApplicationFormSecondPage;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.HashMap;
import static org.junit.Assert.assertTrue;


public class ApplicationFormSecondSteps {

    @Step("поле {0} заполняется значением {1}")
    public void fillField(String fieldName, String value){
        new ApplicationFormSecondPage().fillField(fieldName, value);
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value){
        String actual = new ApplicationFormSecondPage().getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("в поле {0} присутствует сообщение об ошибке {1}")
    public void checkErrorMessageField(String value){
        new ApplicationFormSecondPage().checkFieldErrorMessage( value);
    }

    @Step("заполняются поля")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> fillField(k,v));
    }

    @Step("поля заполнены верно")
    public void checkFillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> checkFillField(k,v));
    }

    @Step("выбирается поле")
    public void stepWaitContinueButton(String field){
        new ApplicationFormSecondPage().waitContinueButton(field);
    }
}