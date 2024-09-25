package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public void goTo(String url) {
        String home = driver.getCurrentUrl();
        driver.navigate().to(home + url);
    }

    public void clickCareerLink() {
        By careerLink = By.xpath("//a[@href=\"/careers\"]");
        WebElement element = waitUntilVisible(5, careerLink);
        element.click();
    }
}
