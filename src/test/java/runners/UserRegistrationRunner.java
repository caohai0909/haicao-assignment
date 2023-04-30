package runners;
import io.cucumber.testng.CucumberOptions;
import steps.Hook;

@CucumberOptions(features = {"src/test/java/features/ui/UserRegistration.feature"} ,
        plugin = {"json:target/cucumber.json", "pretty"},
        glue = "steps")

public class UserRegistrationRunner extends Hook {
}
