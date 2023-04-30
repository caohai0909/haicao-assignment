package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import steps.Hook;

@CucumberOptions(features = {"src/test/java/features/api/ApiUser.feature"} ,
        plugin = {"json:target/cucumber.json", "pretty"},
        glue = "steps")
public class ApiUserRunner extends AbstractTestNGCucumberTests {
}
