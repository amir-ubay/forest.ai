package listeners;

import utils.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import utils.*;

public class TestNGListerner implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        // Capture screenshot on test failure
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
             ScreenshotUtils.captureScreenshot(driver, result.getTestName());
        }
    }
}
