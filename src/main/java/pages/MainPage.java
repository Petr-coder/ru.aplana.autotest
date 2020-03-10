package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//DIV[@class='kit-col kit-col_xs_10 lg-menu__row']")
    WebElement mainMenu;

    @FindBy(xpath = "(//DIV[@class='kit-row'])[8]")
    WebElement subMenu;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void selectMainMenu(String menuItem){
    mainMenu.findElement(By.xpath("//SPAN[@class='lg-menu__text'][text()='"+menuItem+"']")).click();
}

    public void selectSubMenu(String menuItem){
    subMenu.findElement(By.xpath("(//A[@href='/ru/person/bank_inshure/insuranceprogram/life/travel'][text()='Страхование путешественников'][text()='\"+menuItem+\"'])[1]")).click();
    }
}
