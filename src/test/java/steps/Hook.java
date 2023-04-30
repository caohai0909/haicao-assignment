package steps;

import core.config.PropertyUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import static core.common.BuiltInAction.*;
import static core.common.Constant.USER_REGISTRATION_URL;
import static core.locators.WebDriver.openBrowser;

public class Hook extends AbstractTestNGCucumberTests  {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }



    @Before
    public void beforeEcommerceFeature(){
        PropertyUtils.initializePropertyFile();
        String testBrowser = PropertyUtils.property.getProperty("testBrowser");
        openBrowser(testBrowser);
    }

    @After
    public void afterEcommerceFeature(){
        quit();
    }
}
