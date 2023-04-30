package pages.ecommerce;
import static core.common.BuiltInAction.*;
import core.locators.Locator;
import org.openqa.selenium.support.How;


public class OrderReceivedPage {
    private Locator thanksForOrderLbl = new Locator(How.XPATH, "//p[text()='Thank you. Your order has been received.']");

    public Boolean doesThanksMessageDisplayed(){
        return doesControlExist(thanksForOrderLbl.getBy());
    }
    public void doScreenShotOrder(){
        String screenshotPath = getProjectPath() + "\\src\\test\\java\\screenshot\\";
        saveScreenShotEntirePage(screenshotPath, "orderRecord.png");
    }

}
