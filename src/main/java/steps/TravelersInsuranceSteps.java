package steps;

import pages.TravelersInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelersInsuranceSteps extends BaseSteps {

    @Step("нажатие на кнопку - Оформить онлайн")
    public void stepSendAppButton() {
        new TravelersInsurancePage(driver).waitSendAppClickable();
    }
}
