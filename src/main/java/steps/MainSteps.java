package steps;

import io.qameta.allure.Step;
import pages.MainPage;


public class MainSteps extends BaseSteps {

    @Step("выбран пункт меню {0}")
    public void stepSelectMainMenu(String menuItem) {
        new MainPage(driver).selectMainMenu(menuItem);
    }

    @Step("выбран вид страхования {0}")
    public void stepSelectSubMenu(String menuItem) throws InterruptedException {
        new MainPage(driver).selectSubMenu(menuItem);
    }
}
