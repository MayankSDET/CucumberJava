package Runner;

import cucumber.api.*;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "D:\\Automation Workspace\\CucumberJava\\src\\main\\java\\Features\\apitesting.feature",
		glue = "stepDefinations",
		plugin = {"pretty", "html:target/cucumber-report.html"},
		monochrome = true,
		dryRun = false
		//tags = {"@Smoke"}
		)
public class TestRunner {
}