package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelersInsurancePage extends BasePage {

    @FindBy(xpath = "(//H2[@class='kit-heading kit-heading_l product-teaser-full-width__header'][text()='Страхование путешественников'][text()='Страхование путешественников'])[2]")
    public WebElement title;

    @FindBy(xpath = "//B[@class='kit-button__text'][text()='Оформить онлайн']")
    public WebElement sendAppButton;

    public TravelersInsurancePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void waitSendAppClickable(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 250);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//B[@class='kit-button__text'][text()='Оформить онлайн']")))).click();
    }



}
