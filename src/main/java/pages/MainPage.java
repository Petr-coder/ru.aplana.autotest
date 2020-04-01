package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import static util.DriverManager.getDriver;

public class MainPage extends BasePage {

    @FindBy(xpath = "//DIV[@class='kit-col kit-col_xs_10 lg-menu__row']")
    WebElement mainMenu;

    @FindBy(xpath = "//DIV[@id='submenu-5']")
    WebElement subMenu;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(getDriver(), this);

    }

    public void selectMainMenu(String menuItem) {
        Actions action = new Actions(getDriver());
        action.moveToElement(mainMenu.findElement(By.xpath("//SPAN[@class='lg-menu__text'][text()='" + menuItem + "']"))).click().build().perform();
    }

    public void selectSubMenu(String menuItem) throws InterruptedException {
        Actions action = new Actions(getDriver());
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), 5, 250);
        //WebElement travellersInsuranceButton = subMenu.findElement(By.xpath("(//A[@href='/ru/person/bank_inshure/insuranceprogram/life/travel'][text()='" + menuItem + "'])[1]"));

        WebElement travellersInsuranceButton = subMenu.findElement(By.xpath("(//A[text()='" + menuItem + "'][text()='" + menuItem + "'])[1]"));
        //wait.until(ExpectedConditions.elementToBeClickable(travellersInsuranceButton)).click();
        action.moveToElement(travellersInsuranceButton).click().build().perform();
    }
}
