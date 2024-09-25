package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.io.File;

public class JobPage extends CareersPage {
    private final By applyButton = By.xpath("//button[@data-testid=\"apply-now-button\"]");
    private final By applyJobTitle = By.xpath("//div[@data-testid=\"applyJob-title-card\"]");
    private final By applyJobForm = By.xpath("//div[@data-testid=\"applyJob-form-container\"]");
    private final By fullNameInput = By.xpath("//input[@id=\"name\"]");
    private final By emailInput = By.xpath("//input[@id=\"email\"]");
    private final By phoneNumberInput = By.xpath("//input[@id=\"phone\"]");
    private final By phoneCodeInput = By.xpath("//input[@id=\"code\"]");
    private final By cvUploadInput = By.xpath("//input[@id=\"fileInput\"]");
    private final By uploadComplete = By.xpath("//div[div[@data-testid=\"tooltip-career-detail-upload-file\"]]//span[text()=\"Complete\"]");
    private final By coverLetterInput = By.xpath("//textarea[@id=\"additionalMessage\"]");
    private By cancelButton = By.xpath("//button[text()=\"Cancel\"]");
    private final By nextButton = By.xpath("//div[text()=\"Next\"]");
    private final By submitButton = By.xpath("//div[text()=\"Submit\"]");
    private final By jobTitle = By.xpath("//div[@data-testid=\"jobTitle-card\"]/div/div[1]");
    private final By jobPageTitle = By.xpath("//div[@data-testid=\"jobTitle-card\"]");
    private final By successSubmitInfo = By.xpath("//div[@class=\"text-base leading-6 font-medium text-success\"][text()=\"Application Sent\"]");
    private final By successJobSubmit = By.xpath("//div[@class=\"text-sm leading-5 text-success\"]");


    public boolean isJobTitleDisplayed() {
        return find(jobPageTitle).isDisplayed();
    }


    public String getJobTitle() {
        WebElement element = waitUntilVisible(10, jobTitle);
        return element.getText();
    }

    public void applyJob() {
        waitUntilVisible(10, applyButton);
        click(applyButton);
        waitUntilVisible(10, applyJobForm);
        waitUntilVisible(10, applyJobTitle);
        waitUntilVisible(10, fullNameInput);
        waitUntilVisible(10, emailInput);
        waitUntilVisible(10, phoneNumberInput);
    }

    public void setFullName(String name) {
        set(fullNameInput, name);
    }

    public void setEmail(String email) {
        set(emailInput, email);
    }

    public void setPhoneNumber(String code, String number) {
        driver.findElement(phoneCodeInput).sendKeys(code + Keys.ENTER);
        set(phoneNumberInput, number);
    }

    public void nextUploadFile() {
        click(nextButton);
        waitUntilPresence(10, cvUploadInput);
    }

    public void clickNext() {
        click(nextButton);
    }

    public void uploadCv() {
        File testUploadFile = new File("src/test/resources/cvdummy.pdf");
        WebElement inputFile = driver.findElement(cvUploadInput);
        inputFile.sendKeys(testUploadFile.getAbsolutePath());
        waitUntilPresence(10, uploadComplete);
    }

    public void uploadCvUsingDragAndDrop() {
        By dropLocator = By.xpath("//*[@data-testid=\"upload-file-apply-job\"]");
        waitUntilPresence(10, dropLocator);
        File testUploadFile = new File("src/test/resources/cvdummy.pdf");
        String filePath = testUploadFile.getAbsolutePath();


        WebElement dropArea = driver.findElement(dropLocator);


        String js = "var target = arguments[0], "
                + "file = new File([" + "new Blob(['" + filePath + "'], {type: 'application/pdf'})" + "], '" + testUploadFile.getName() + "');"
                + "var dataTransfer = new DataTransfer();"
                + "dataTransfer.items.add(file);"
                + "var event = new DragEvent('drop', {dataTransfer: dataTransfer});"
                + "target.dispatchEvent(event);";


        ((JavascriptExecutor) driver).executeScript(js, dropArea);


        waitUntilPresence(10, uploadComplete);
    }

    public void cvUploadCompleteVisible() {
        waitUntilPresence(10, uploadComplete);
    }

    public void nextCoverLetter() {
        click(nextButton);
        waitUntilPresence(10, coverLetterInput);
    }

    public void cvUploadVisible() {
        waitUntilPresence(10, cvUploadInput);
    }

    public void setCoverLetter(String text) {
        set(coverLetterInput, text);
    }

    public void submitJobApplication() {
        click(submitButton);
    }

    public WebElement getSuccessInfoElement() {
        waitUntilPresence(10, successSubmitInfo);
        return driver.findElement(successSubmitInfo);
    }

    public String getSuccessJobSubmitText() {
        waitUntilPresence(10, successJobSubmit);
        WebElement element = driver.findElement(successJobSubmit);
        return element.getText();
    }

}
