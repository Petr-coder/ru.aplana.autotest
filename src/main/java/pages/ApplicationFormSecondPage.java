package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;
import static util.DriverManager.getDriver;

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

    @FindBy(xpath = "//*[contains(text(),'Продолжить')]")
    public WebElement continueButton;

    public ApplicationFormSecondPage() {
        PageFactory.initElements(getDriver(), this);
        (new WebDriverWait(getDriver(), 10))
                .until(ExpectedConditions.visibilityOf(title));
    }

    public void fillField(String  fieldName, String value) {
        switch (fieldName) {
            case "Фамилия /Surname":
                getDriver().findElement(By.id("surname_vzr_ins_0")).click();
                getDriver().findElement(By.id("surname_vzr_ins_0")).sendKeys(value);
                //fillField(lastNameOfInsured, value);

                break;
            case "Имя / Given names":
                fillField(firstNameOfInsured, value);
                break;
            case "Дата рождения/Застрахованные":
                fillField(contactDateOfInsured, value);
                break;
            case "Фамилия":
                //fillField(lastNameOfPolicyholder, value);
                //lastNameOfPolicyholder.sendKeys(Keys.TAB);
                getDriver().findElement(By.id("person_lastName")).click();
                getDriver().findElement(By.id("person_lastName")).sendKeys(value);
                break;
            case "Имя":
                getDriver().findElement(By.id("person_firstName")).click();
                getDriver().findElement(By.id("person_firstName")).sendKeys(value);
                break;
            case "Отчество":
                fillField(middleNameOfPolicyholder, value);
                middleNameOfPolicyholder.sendKeys(Keys.TAB);
                break;
            case "Дата рождения/Страхователь":
                fillField(contactDateOfPolicyholder, value);
                break;

            case "passportSeries":
                //fillField(passportSeries, value);
                //passportSeries.sendKeys(Keys.TAB);
                getDriver().findElement(By.id("passportSeries")).click();
                getDriver().findElement(By.id("passportSeries")).sendKeys(value);
                break;
            case "passportNumber":
                fillField(passportNumber, value);
                break;
            case "Дата выдачи":
                fillField(documentDateOfPolicyholder, value);
                break;
            case "Кем выдан":
                //fillField(documentIssue, value);
                //documentIssue.sendKeys(Keys.TAB);
                getDriver().findElement(By.id("documentIssue")).click();
                getDriver().findElement(By.id("documentIssue")).sendKeys("Кем-то");
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }


    public String getFillField(String fieldName) {
        switch (fieldName) {
            case "Фамилия /Surname":
                return lastNameOfInsured.getAttribute("value");
            case "Имя / Given names":
                return firstNameOfInsured.getAttribute("value");
            case "Дата рождения/Застрахованные":
                return contactDateOfInsured.getAttribute("value");
            case "Фамилия":
                return lastNameOfPolicyholder.getAttribute("value");
            case "Имя":
                return firstNameOfPolicyholder.getAttribute("value");
            case "Отчество":
                return middleNameOfPolicyholder.getAttribute("value");
            case "Дата рождения/Страхователь":
                return contactDateOfPolicyholder.getAttribute("value");
            case "passportSeries":
                return passportSeries.getAttribute("value");
            case "passportNumber":
                return passportNumber.getAttribute("value");
            case "Дата выдачи":
                return documentDateOfPolicyholder.getAttribute("value");
            case "Кем выдан":
                return documentIssue.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    public void checkFillField(String field, String value) {
        String actual = new ApplicationFormSecondPage().getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    public void checkFieldErrorMessage(String errorMessage){
        String xpath = "//*[@class='alert-form alert-form-error']";
        String actualValue = getDriver().findElement(By.xpath(xpath)).getText();
        Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }

    public void waitContinueButton() {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), 7, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

}
