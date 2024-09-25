package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
            // Setup ChromeDriver using WebDriverManager
            WebDriverManager.chromedriver().setup();

            // Create ChromeOptions object to enable headless mode and other configurations
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");  // Run Chrome in headless mode
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu"); // Disable GPU acceleration
            options.addArguments("--window-size=1920x1080");

            // Initialize the WebDriver with ChromeOptions
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
