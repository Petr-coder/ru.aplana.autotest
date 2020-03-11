import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import pages.BasePage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class InsuranceTest extends BasePage {

    WebDriver driver;
    String baseUrl;



    @Before
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.rgs.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    @Ignore
        public void testInsurance(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/ol[1]/li/a")).click();
        driver.findElement(By.xpath("//*[contains(text(),'ДМС')]")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        WebElement sendBtn = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/a[3]"));
        wait.until(ExpectedConditions.visibilityOf(sendBtn)).click();


        WebElement title = driver.findElement(By.xpath("//h4[@class='modal-title']"));
        wait.until(ExpectedConditions.visibilityOf(title));

        assertEquals("Заявка на добровольное медицинское страхование", title.getText());

        fillInField(By.name("LastName"), "Иванов");
        fillInField(By.name("FirstName"), "Иван");
        fillInField(By.name("MiddleName"), "Иванович");

        new Select(driver.findElement(By.name("Region"))).selectByVisibleText("Москва");

        fillInField(By.name("Comment"), "SomethingForNothing");
        fillInField(By.name("Email"), "Иванович");

        driver.findElement(By.xpath("//input[@class='checkbox']")).click();
        driver.findElement(By.xpath("//*[@id='button-m']")).click();


        assertEquals("Москва",
                new Select(driver.findElement(By.name("Region"))).getAllSelectedOptions().get(0).getText());
        assertEquals("Введите адрес электронной почты",
                driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[2]/div[2]/form/div[2]/div[6]/div/label/span")).getText());

        assertEquals("Иванов",
                driver.findElement(By.name("LastName")).getAttribute("value"));
        assertEquals("Иван",
                driver.findElement(By.name("FirstName")).getAttribute("value"));
        assertEquals("Иванович",
                driver.findElement(By.name("MiddleName")).getAttribute("value"));
        assertEquals("Иванович", driver.findElement(By.name("Email")).getAttribute("value"));
        assertEquals("SomethingForNothing", driver.findElement(By.name("Comment")).getAttribute("value"));
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
