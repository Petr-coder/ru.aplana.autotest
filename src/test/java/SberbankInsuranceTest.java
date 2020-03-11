import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class SberbankInsuranceTest {


    WebDriver driver;
    String baseUrl;

    @Before
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void testInsurance(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 250);

        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//SPAN[@class='lg-menu__text'][text()='Страхование']"));
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath("(//*[text()='Страхование путешественников'][text()='Страхование путешественников'])[1]"))).click().build().perform();


        //Проверить наличие на странице заголовка – Страхование путешественников
        WebElement fuckingTitle = driver.findElement(By.xpath("(//H2[@class='kit-heading kit-heading_l product-teaser-full-width__header'][text()='Страхование путешественников'][text()='Страхование путешественников'])[2]"));
        wait.until(ExpectedConditions.visibilityOf(fuckingTitle)).click();


        assertEquals("«Сбербанк» - Страхование путешественников",	driver.getTitle());
        System.out.println("Page	title	is:	"	+	driver.getTitle());

        WebElement onlineRegistration = driver.findElement(By.xpath("//B[@class='kit-button__text'][text()='Оформить онлайн']"));
        wait.until(ExpectedConditions.elementToBeClickable(onlineRegistration)).click();

        driver.findElement(By.xpath("//H2[@_ngcontent-c1=''][text()='Страхование путешественников']"));
        WebElement title = driver.findElement(By.xpath("//H2[@_ngcontent-c1=''][text()='Страхование путешественников']"));
        wait.until(ExpectedConditions.visibilityOf(title));

        driver.findElement(By.xpath("//*[text()='Минимальная']")).click();

        WebElement preparation = driver.findElement(By.xpath("//BUTTON[@class='btn btn-primary btn-large'][text()='Оформить']"));
        wait.until(ExpectedConditions.elementToBeClickable(preparation)).click();


        fillInField(By.id("surname_vzr_ins_0"), "Ivan");
        fillInField(By.id("name_vzr_ins_0"), "Ivan");
        fillInField(By.id("birthDate_vzr_ins_0"), "10011990");
        driver.findElement(By.id("person_lastName")).click();
        driver.findElement(By.id("person_lastName")).sendKeys("Иванов");
        fillInField(By.id("person_firstName"), "Иван");
        fillInField(By.id("person_middleName"), "Иванович");
        fillInField(By.id("person_birthDate"), "10011990");

        driver.findElement(By.id("passportSeries")).click();
        driver.findElement(By.id("passportSeries")).sendKeys("5200");
        fillInField(By.id("passportNumber"), "360666");
        fillInField(By.id("documentDate"), "10102010");
        driver.findElement(By.id("documentIssue")).click();
        driver.findElement(By.id("documentIssue")).sendKeys("Кем-то");


        assertEquals("Ivan",
                driver.findElement(By.id("surname_vzr_ins_0")).getAttribute("value"));
        assertEquals("Ivan",
                driver.findElement(By.id("name_vzr_ins_0")).getAttribute("value"));
        assertEquals("10.01.1990",
                driver.findElement(By.id("birthDate_vzr_ins_0")).getAttribute("value"));

        assertEquals("Иванов",
                driver.findElement(By.id("person_lastName")).getAttribute("value"));
        assertEquals("Иван",
                driver.findElement(By.id("person_firstName")).getAttribute("value"));
        assertEquals("Иванович",
                driver.findElement(By.id("person_middleName")).getAttribute("value"));
        assertEquals("10.01.1990",
                driver.findElement(By.id("person_birthDate")).getAttribute("value"));
        assertEquals("5200",
                driver.findElement(By.id("passportSeries")).getAttribute("value"));
        assertEquals("360666",
                driver.findElement(By.id("passportNumber")).getAttribute("value"));
        assertEquals("10.10.2010",
                driver.findElement(By.id("documentDate")).getAttribute("value"));
        assertEquals("Кем-то",
                driver.findElement(By.id("documentIssue")).getAttribute("value"));



        driver.findElement(By.xpath("//*[contains(text(),'Продолжить')]")).click();


        assertEquals("При заполнении данных произошла ошибка",
                driver.findElement(By.xpath("//*[@class='alert-form alert-form-error']")).getText());
    }


    public void fillInField (By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }





    @After
    public void afterTest(){

        driver.quit();

    }




}