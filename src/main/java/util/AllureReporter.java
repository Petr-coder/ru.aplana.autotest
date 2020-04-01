package util;

import io.qameta.allure.Attachment;
import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static util.DriverManager.getDriver;

public class AllureReporter extends AllureJunit4 {

    @Override
    public void testFailure(Failure failure) throws Exception {
        takeScreenShot();
        super.testFailure(failure);
    }
    @Attachment(type= "img/png", value = "Скриншот при ошибке")
    public byte [] takeScreenShot(){

        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
