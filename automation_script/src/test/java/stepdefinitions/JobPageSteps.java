package stepdefinitions;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.BasePage;
import pages.CareersPage;
import pages.JobPage;
import utils.DriverManager;

public class JobPageSteps {

    protected WebDriver driver;
    protected BasePage basePage;
    protected CareersPage careersPage;
    protected JobPage jobPage;

    @Given("User opens qa engineer job")
    public void user_open_qa_engineer_job() {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        String url = "https://theforest.ai/careers/qa-engineer";
        driver.get(url);

        // Initialize page objects
        basePage = new BasePage();
        basePage.setDriver(driver);
        jobPage = new JobPage();
    }

    @When("User apply the job")
    public void user_apply_the_job() {
        jobPage.applyJob();
    }

    @When("User fills personal data")
    public void user_fills_personal_data(){
        jobPage.setFullName("John Doe");
        jobPage.setEmail("johndoe@email.com");
        jobPage.setPhoneNumber("62", "81999099909");
        jobPage.nextUploadFile();
    }

    @When("User fills empty name")
    public void user_fills_empty_name(){
        jobPage.setFullName("");
        jobPage.setEmail("johndoe@email.com");
        jobPage.setPhoneNumber("62", "81999099909");
        jobPage.clickNext();
    }

    @When("User fills empty email")
    public void user_fills_empty_email(){
        jobPage.setFullName("John Doe");
        jobPage.setEmail("");
        jobPage.setPhoneNumber("62", "81999099909");
        jobPage.clickNext();
    }

    @When("User fills empty code")
    public void user_fills_empty_code(){
        jobPage.setFullName("John Doe");
        jobPage.setEmail("johndoe@email.com");
        jobPage.setPhoneNumber("", "81999099909");
        jobPage.clickNext();
    }

    @When("User fills empty phone")
    public void user_fills_empty_phone(){
        jobPage.setFullName("John Doe");
        jobPage.setEmail("johndoe@email.com");
        jobPage.setPhoneNumber("62", "");
        jobPage.clickNext();
    }

    @Then("User sees empty name validation")
    public void user_sees_empty_name_validation(){
        By textLocator = By.xpath("//span[text()=\"Name is required\"]");
        WebElement element = driver.findElement(textLocator);
        Assert.assertTrue(element.isDisplayed(), "Input name validation is not displayed");
    }

    @Then("User sees empty email validation")
    public void user_sees_empty_email_validation(){
        By textLocator = By.xpath("//span[text()=\"Email is required\"]");
        WebElement element = driver.findElement(textLocator);
        Assert.assertTrue(element.isDisplayed(), "Input email validation is not displayed");
    }

    @Then("User sees empty code validation")
    public void user_sees_empty_code_validation(){
        By textLocator = By.xpath("//span[text()=\"Code is required\"]");
        WebElement element = driver.findElement(textLocator);
        Assert.assertTrue(element.isDisplayed(), "Input code validation is not displayed");
    }

    @Then("User sees empty phone validation")
    public void user_sees_empty_phone_validation(){
        By textLocator = By.xpath("//span[text()=\"Phone number is required\"]");
        WebElement element = driver.findElement(textLocator);
        Assert.assertTrue(element.isDisplayed(), "Input phone number validation is not displayed");
    }

    @When("User uploads cv")
    public void user_uploads_cv(){
        jobPage.uploadCv();
        jobPage.nextCoverLetter();
    }

    @When("User uploads valid cv")
    public void user_uploads_valid_cv(){
        jobPage.uploadCv();
    }

    @When("User drag and drop valid cv")
    public void user_drag_and_drop_valid_cv(){
        jobPage.uploadCvUsingDragAndDrop();
    }

    @When("User does not upload cv")
    public void user_does_not_upload_cv(){
        jobPage.clickNext();
    }

    @When("User sets cover letter")
    public void user_sets_cover_letter(){
        jobPage.setCoverLetter("Automation testing cover letter");
    }

    @When("User submit job application")
    public void user_submit_job_application() {
        jobPage.submitJobApplication();
    }

    @Then("User sees success submit info")
    public void user_sees_success_submit_info() {
        WebElement successInfo = jobPage.getSuccessInfoElement();
        Assert.assertTrue(successInfo.isDisplayed(), "Success info should displayed after success submit job aplication");
        String jobTitle = jobPage.getJobTitle();
        String successJobSubmitText = jobPage.getSuccessJobSubmitText();
        Assert.assertTrue(successJobSubmitText.contains(jobTitle), "Success job application text doest not contain correct job title");
    }

    @Then("User sees error info not upload cv")
    public void user_sees_error_info_not_upload_cv(){
        By text1Locator = By.xpath("//div[text()=\"You haven’t uploaded any files.\"]");
        By text2Locator = By.xpath("//div[text()=\"Please upload your CV or resume.\"]");
        WebElement text1 = driver.findElement(text1Locator);
        WebElement text2 = driver.findElement(text2Locator);
        Assert.assertTrue(text1.isDisplayed(), "Error text 'haven't upload any files' is not visible");
        Assert.assertTrue(text2.isDisplayed(), "Error text 'please upload cv' is not visible");
    }

    @Then("User sees upload cv form")
    public void user_sees_upload_cv_form() {
        jobPage.cvUploadVisible();
    }

    @Then("User sees complete info")
    public void user_sees_complete_info() {
        jobPage.cvUploadCompleteVisible();
    }

}
