package runners;


import io.cucumber.testng.CucumberOptions;
import steps.Hook;

@CucumberOptions(features = {"src/test/java/features/ui/SearchProduct.feature"} ,
        plugin = {"json:target/cucumber.json", "pretty"},
        glue = "steps")
public class SearchProductRunner extends Hook {
}
