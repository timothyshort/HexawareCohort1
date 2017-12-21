package cucumber.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features",
		glue = "cucumber.stepDefinitions",
		tags = {"@ShopCart", "~@SmokeTest", "~@Ignore"},
		dryRun = false
		)
public class CucumberTests {

	// AND tags: { "@tag1", "@tag2", "@tag3" }
	// OR tags: { "@tag1, @tag2", "@tag3" }
	// NOT : "~@tag"
	// In general, use the @Ignore tag to skip scenarios/features, and denote in tags "~@Ignore"
}
