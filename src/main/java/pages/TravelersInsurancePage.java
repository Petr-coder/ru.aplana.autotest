package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static util.DriverManager.getDriver;

public class TravelersInsurancePage extends BasePage {

    @FindBy(xpath = "(//H2[@class='kit-heading kit-heading_l product-teaser-full-width__header'][text()='Страхование путешественников'][text()='Страхование путешественников'])[1]")
    public WebElement title;

    @FindBy(xpath = "//B[@class='kit-button__text'][text()='Оформить онлайн']")
    public WebElement sendAppButton;

    public TravelersInsurancePage(WebDriver driver) {
        PageFactory.initElements(getDriver(), this);
    }

    public void waitSendAppClickable() {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), 5, 250);
        wait.until(ExpectedConditions.visibilityOf(sendAppButton)).click();
    }


}
