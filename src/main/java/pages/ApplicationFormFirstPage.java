package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import static util.DriverManager.getDriver;

public class ApplicationFormFirstPage extends BasePage {


    @FindBy(xpath = "(//DIV[@_ngcontent-c1=''])[4]")
    public static WebElement titleOfApplicationSelectPolicy;

    @FindBy(xpath = "(//DIV[@_ngcontent-c4=''])[4]")
    public WebElement titleOfApplicationPreparation;

    @FindBy(xpath = "//FIELDSET[@class='no-offset non-border']")
    public WebElement insuranceCoverAmount;


    public ApplicationFormFirstPage() {
        super();
        (new WebDriverWait(getDriver(), 10))
                .until(ExpectedConditions.visibilityOf(titleOfApplicationSelectPolicy));
    }

    public void waitInsuranceCoverAmount(String field) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), 5, 250);
        wait.until(ExpectedConditions.elementToBeClickable(
                insuranceCoverAmount.findElement(By.xpath("//*[text()='"+field+"']")))).click();
        System.out.println("проверка");
    }

    public void waitMakeOnlineApplication(String field) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), 5, 250);
        wait.until(ExpectedConditions.elementToBeClickable(
                getDriver().findElement(By.xpath("//BUTTON[@class='btn btn-primary btn-large'][text()='"+field+"']")))).click();
        System.out.println("проверка222");
    }
}
