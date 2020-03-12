package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationFormSecondPage extends BasePage {

    @FindBy(xpath = "//H2[@_ngcontent-c1=''][text()='Страхование путешественников']")
    public WebElement title;

    @FindBy(id = "surname_vzr_ins_0")
    WebElement lastNameOfInsured;

    @FindBy(id = "name_vzr_ins_0")
    WebElement firstNameOfInsured;

    @FindBy(id = "birthDate_vzr_ins_0")
    WebElement contactDateOfInsured;

    @FindBy(id = "person_lastName")
    WebElement lastNameOfPolicyholder;

    @FindBy(id = "person_firstName")
    WebElement firstNameOfPolicyholder;

    @FindBy(id = "person_middleName")
    WebElement middleNameOfPolicyholder;

    @FindBy(id = "person_birthDate")
    WebElement contactDateOfPolicyholder;

    @FindBy(id = "passportSeries")
    public WebElement passportSeries;

    @FindBy(id = "passportNumber")
    public WebElement passportNumber;

    @FindBy(id = "documentDate")
    WebElement documentDateOfPolicyholder;

    @FindBy(id = "documentIssue")
    public WebElement documentIssue;

    @FindBy(xpath = "//button[contains(text(),'Отправить')]")
    public WebElement sendButton;

    public ApplicationFormSecondPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(title));
        this.driver = driver;
    }

    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Фамилия /Surname":
                fillField(lastNameOfInsured, value);
                break;
            case  "Имя / Given names":
                fillField(firstNameOfInsured, value);
                break;
            case  "Дата рождения":
                fillField(contactDateOfInsured, value);
                break;
            case  "Фамилия":
                fillField(lastNameOfPolicyholder, value);
                break;

            case  "Имя":
                fillField(firstNameOfPolicyholder, value);
                break;
            case  "Отчество":
                fillField(middleNameOfPolicyholder, value);
                middleNameOfPolicyholder.sendKeys(Keys.TAB);
                break;

            case  "Дата рождения":
                fillField(contactDateOfPolicyholder, value);
                break;

            case  "Серия и номер паспорта":
                fillField(passportSeries, value);
                break;


            case  "Серия и номер паспорта":
                fillField(passportNumber, value);
                break;



            case  "Дата выдачи":
                fillField(documentDateOfPolicyholder, value);
                break;

            case  "Кем выдан":
                fillField(documentIssue, value);
                break;

            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }


}
