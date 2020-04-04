package steps;
import io.cucumber.java.en.When;
import pages.MainPage;

import static util.DriverManager.getDriver;


public class MainSteps  {

    @When("^Выбран пункт меню \"(.*)\"$")
    public void stepSelectMainMenu(String menuItem) {
        new MainPage(getDriver()).selectMainMenu(menuItem);
    }

    @When("^Выбран вид страхования \"(.*)\"$")
    public void stepSelectSubMenu(String menuItem) throws InterruptedException {
        new MainPage(getDriver()).selectSubMenu(menuItem);
    }
}
