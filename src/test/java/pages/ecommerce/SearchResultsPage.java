package pages.ecommerce;
import core.locators.Locator;
import models.ProductModel;
import models.SearchProductModel;
import org.openqa.selenium.support.How;
import static core.common.BuiltInAction.*;

public class SearchResultsPage {
    private String existingResultLocation = "//a[.='{0}']";
    private String nonExistingResultLocation = "//p[.='{0}']";

    public boolean doesRearechResultDispalyed(String result){
        Locator realExistingResult = new Locator(How.XPATH, existingResultLocation.replace("{0}", result));
        Locator realNonExistingResultLocation = new Locator(How.XPATH, nonExistingResultLocation.replace("{0}", result));

        if (doesControlExist(realExistingResult.getBy())){
            return true;
        } else if(doesControlExist(realNonExistingResultLocation.getBy())){
            return true;
        }else {
            return false;
        }
    }

}
