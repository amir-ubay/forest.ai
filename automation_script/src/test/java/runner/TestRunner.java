package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@Listeners(listeners.TestNGListerner.class)
@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature files
        glue = {"stepdefinitions", "hooks"},                // Path to your step definitions
        plugin = {                                // Plugins for reporting
                "pretty",
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
