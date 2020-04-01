package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static util.DriverManager.getDriver;

public class BaseSteps {

    protected static String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();

    @Before
    public void startScenario() {
        getDriver().get("http://www.sberbank.ru/ru/person");
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @After
    public static void tearDown() throws Exception {
        getDriver().quit();
    }

}