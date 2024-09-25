package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.BasePage;
import pages.CareersPage;
import utils.DriverManager;

public class CareersPageSteps {
    protected WebDriver driver;
    protected BasePage basePage;
    protected CareersPage careersPage;

    @Given("User opens careers page")
    public void user_opens_careers_page() {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        String url = "https://theforest.ai/careers";
        driver.get(url);

        // Initialize page objects
        basePage = new BasePage();
        basePage.setDriver(driver);
        careersPage = new CareersPage();
    }

    @When("User clicks job card software engineer")
    public void user_clicks_job_card_software_engineer() {
        careersPage.openJobSoftwareEngineer();
    }

    @Then("User sees correct job page title software engineer")
    public void user_sees_correct_job_page_title_software_engineer() {
        String actual = BasePage.getPageTitle();
        String expected = "Careers - Senior Software Engineer | Forest Technologies";
        Assert.assertEquals(actual, expected, "Page title job page Software Engineer is not correct");
    }

    @When("User clicks job card qa engineer")
    public void user_clicks_job_card_qa_engineer() {
        careersPage.openJobQaEngineer();
    }

    @Then("User sees correct job page title qa engineer")
    public void user_sees_correct_job_page_title_qa_engineer() {
        String actual = BasePage.getPageTitle();
        String expected = "Careers - QA Engineer | Forest Technologies";
        Assert.assertEquals(actual, expected, "Page title job page Software Engineer is not correct");
    }

    @When("User clicks job card unity developer")
    public void user_clicks_job_card_unity_developer() {
        careersPage.openUnityDeveloper();
    }

    @Then("User sees correct job page title unity developer")
    public void user_sees_correct_job_page_title_unity_developer() {
        String actual = BasePage.getPageTitle();
        String expected = "Careers - undefined | Forest Technologies";
        Assert.assertEquals(actual, expected, "Page title job page Software Engineer is not correct");
    }
}
