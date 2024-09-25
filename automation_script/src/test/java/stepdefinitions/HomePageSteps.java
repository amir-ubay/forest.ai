package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.BasePage;
import pages.CareersPage;
import pages.HomePage;
import utils.DriverManager;

public class HomePageSteps {

    protected WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;

    @Given("User opens homepage")
    public void user_opens_homepage() {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        String url = "https://theforest.ai";
        driver.get(url);

        // Initialize page objects
        basePage = new BasePage();
        basePage.setDriver(driver);
        homePage = new HomePage();
    }

    @When("User clicks career link")
    public void user_clicks_career_link() {
        homePage.clickCareerLink();
    }

    @Then("User sees correct careers page title")
    public void user_sees_correct_careers_page_title() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Careers | Forest Technologies");
    }

    @Then("User sees correct homepage title")
    public void user_sees_correct_homepage_title() {
        String pageTitle = driver.getTitle();
        Assert.assertNotEquals(pageTitle, "Forest Technologies | Leading B2B Technology Solutions");
    }
}
