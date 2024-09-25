package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public static WebDriver driver;

    public WebElement waitUntilVisible(Integer time, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public WebElement waitUntilPresence(Integer time, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

    public static void waitUntilPageReady(String url) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(url));
    }

    public static String getPageTitle() {
        return driver.getTitle();
    }

    public void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    protected String getText(By locator) {
        WebElement element = driver.findElement(By.xpath("//div[@data-testid=\"jobTitle-card\"]/div/div[1]"));
        return element.getText();
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected void set(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    public static void delay(int time) {
        try {
            Thread.sleep(time);
        } catch(InterruptedException exc) {
            exc.printStackTrace();
        }
    }
}
