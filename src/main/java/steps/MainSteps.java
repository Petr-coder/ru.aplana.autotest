package steps;
import io.qameta.allure.Step;
import pages.MainPage;

import static util.DriverManager.getDriver;


public class MainSteps extends BaseSteps {

    @Step("выбран пункт меню {0}")
    public void stepSelectMainMenu(String menuItem) {
        new MainPage(getDriver()).selectMainMenu(menuItem);
    }

    @Step("выбран вид страхования {0}")
    public void stepSelectSubMenu(String menuItem) throws InterruptedException {
        new MainPage(getDriver()).selectSubMenu(menuItem);
    }
}
