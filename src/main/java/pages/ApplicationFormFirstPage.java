package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationFormFirstPage extends BasePage {


    @FindBy(xpath = "(//DIV[@_ngcontent-c1=''])[4]")
    public static WebElement titleOfApplicationSelectPolicy;

    @FindBy(xpath = "(//DIV[@_ngcontent-c4=''])[4]")
    public WebElement titleOfApplicationPreparation;

    @FindBy(xpath = "//FIELDSET[@class='no-offset non-border']")
    public WebElement insuranceCoverAmount;


    public ApplicationFormFirstPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(titleOfApplicationSelectPolicy));
        this.driver = driver;
    }

    public void waitInsuranceCoverAmount(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 250);
        wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("//*[text()='Минимальная']")))).click();
    }

    public void waitMakeOnlineApplication(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 250);
        wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("//BUTTON[@class='btn btn-primary btn-large'][text()='Оформить']")))).click();
    }



}
