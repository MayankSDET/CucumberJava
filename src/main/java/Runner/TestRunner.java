package Runner;

import cucumber.api.*;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Mayank Shrivastav\\git\\repository\\CucumberJava\\src\\main\\java\\Features\\Orange.feature",
		glue = "stepDefinations",
		plugin = {"pretty", "html:target/cucumber-report.html"},
		monochrome = true,
		dryRun = false
		//tags = {"@Smoke"}
		)
public class TestRunner {
}