package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CareersPage extends BasePage {
    private final By cardSeniorSoftwareEngineer = By.xpath("//div[@data-testid=\"job-card-senior-software-engineer\"]");
    private final By cardQaEngineer = By.xpath("//div[@data-testid=\"job-card-qa-engineer\"]");
    private final By cardUnityDeveloper= By.xpath("//div[@data-testid=\"job-card-senior-unity-developer\"]");
    private final By pageTitle0 = By.xpath("//span[@data-testid=\"-word_0\"]");

    public String getTitle0() {
        WebElement element = waitUntilVisible(5, pageTitle0);
        return element.getText();
    }

    public void openJobSoftwareEngineer() {
        WebElement element = waitUntilVisible(5, cardSeniorSoftwareEngineer);
        element.click();
        waitUntilPageReady("senior-software-engineer");
    }

    public void openJobQaEngineer() {
        WebElement element = waitUntilVisible(5, cardQaEngineer);
        element.click();
        waitUntilPageReady("qa-engineer");
    }

    public void openUnityDeveloper() {
        WebElement element = waitUntilVisible(5, cardUnityDeveloper);
        element.click();
        waitUntilPageReady("senior-unity-developer");
    }
}
