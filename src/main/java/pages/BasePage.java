package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static util.DriverManager.getDriver;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void fillField(WebElement field, String value){
        field.clear();
        field.sendKeys(value);
    }
}