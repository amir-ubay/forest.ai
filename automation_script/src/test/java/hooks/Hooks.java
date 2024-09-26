package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import utils.DriverManager;
import utils.ScreenshotUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    WebDriver driver;

    @Before
    public void setup() {
        driver = DriverManager.getDriver();
    }

    @After
    public void tearDown(@org.jetbrains.annotations.NotNull Scenario scenario) {
        if (driver != null) {
            try {
                if (scenario.isFailed()) {
                    ScreenshotUtils.captureScreenshot(driver, scenario.getName());
                }
            } catch (WebDriverException e) {
                System.err.println("Unable to capture screenshot: " + e.getMessage());
            } finally {
                // Ensure driver is quit only once and avoid using it after quit
                DriverManager.quitDriver();
            }
        }
    }
}
