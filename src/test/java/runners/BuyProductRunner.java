package runners;
import io.cucumber.testng.CucumberOptions;
import steps.Hook;

@CucumberOptions(features = {"src/test/java/features/ui/BuyProduct.feature"} ,
        plugin = {"json:target/cucumber.json", "pretty"},
        tags = "@Test",
        glue = "steps")

public class BuyProductRunner extends Hook {
}
