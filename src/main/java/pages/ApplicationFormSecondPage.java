package pages;

import org.openqa.selenium.By;
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
            case  "birthDate_vzr_ins_0":
                fillField(contactDateOfInsured, value);
                break;
            case  "Фамилия":
                fillField(lastNameOfPolicyholder, value);
                lastNameOfPolicyholder.sendKeys(Keys.TAB);
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

            case  "passportSeries":
                fillField(passportSeries, value);
                break;
            case  "passportNumber":
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


    public String getFillField(String fieldName){
        switch (fieldName){
            case  "Фамилия /Surname":
                return lastNameOfInsured.getAttribute("value");
            case  "Имя / Given names":
                return firstNameOfInsured.getAttribute("value");
            case  "birthDate_vzr_ins_0":
                return contactDateOfInsured.getAttribute("value");
            case  "Фамилия":
                return lastNameOfPolicyholder.getAttribute("value");
            case  "Имя":
                return firstNameOfPolicyholder.getAttribute("value");
            case  "Отчество":
                return middleNameOfPolicyholder.getAttribute("value");
            case  "Дата рождения":
                return contactDateOfPolicyholder.getAttribute("value");
            case  "passportSeries":
                return passportSeries.getAttribute("value");
            case  "passportNumber":
                return passportNumber.getAttribute("value");
            case  "Дата выдачи":
                return documentDateOfPolicyholder.getAttribute("value");
            case  "Кем выдан":
                return documentIssue.getAttribute("value");
                   }
        throw new AssertionError("Поле не объявлено на странице");
    }

    public void checkFieldErrorMessage(String field, String errorMessage){
        String xpath = "//*[text()='"+field+"']/..//*[@class='validation-error-text']";
        String actualValue = driver.findElement(By.xpath(xpath)).getText();
        org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }



}
