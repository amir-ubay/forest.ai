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

public class TestNGListerner implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        // Capture screenshot on test failure
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            try {
                // Save the screenshot to a specific location with a unique name
                Files.copy(source.toPath(), Paths.get("screenshots", result.getName() + ".png"));
                System.out.println("Screenshot saved for failed test: " + result.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
