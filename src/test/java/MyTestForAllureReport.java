import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

public class MyTestForAllureReport extends BaseSteps {

    @Title("Страхование")
    @Test
    public void textInsurance() throws InterruptedException {
        MainSteps mainSteps = new MainSteps();
        TravelersInsuranceSteps travelersInsuranceSteps = new TravelersInsuranceSteps();
        ApplicationFormFirstSteps applicationFormFirstSteps = new ApplicationFormFirstSteps();
        ApplicationFormSecondSteps applicationFormSecondSteps = new ApplicationFormSecondSteps();

        HashMap<String, String> testData = new HashMap<>();
        testData.put("Фамилия /Surname", "Ivanov");
        testData.put("Имя / Given names", "Ivan");
        testData.put("Дата рождения/Застрахованные", "10.10.1990");
        testData.put("Фамилия", "Иванов");
        testData.put("Имя", "Иван");
        testData.put("Отчество", "Иванович");
        testData.put("Дата рождения/Страхователь", "10.10.1990");
        testData.put("passportSeries", "5220");
        testData.put("Дата выдачи", "10.10.2010");
        testData.put("passportNumber", "363677");
        testData.put("Кем выдан", "Кем-то");

        mainSteps.stepSelectMainMenu("Страхование");
        mainSteps.stepSelectSubMenu("Страхование путешественников");

        travelersInsuranceSteps.stepSendAppButton();

        applicationFormFirstSteps.stepWaitInsuranceCoverAmount("Минимальная");
        applicationFormFirstSteps.stepWaitMakeOnlineApplication("Оформить");

        applicationFormSecondSteps.fillFields(testData);
        applicationFormSecondSteps.stepWaitContinueButton();
        applicationFormSecondSteps.checkFillFields(testData);
        applicationFormSecondSteps.checkErrorMessageField("При заполнении данных произошла ошибка");

    }
}
