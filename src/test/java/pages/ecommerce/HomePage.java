package pages.ecommerce;
import core.locators.Locator;
import models.ProductModel;
import models.SearchProductModel;
import org.openqa.selenium.support.How;
import static core.common.BuiltInAction.*;


public class HomePage {

    private String productItemLocation = "//h3[.='{0}']/parent::a/following-sibling::a";
    private Locator cartBtn = new Locator(How.XPATH, "//span[@class='cartcontents']");
    private Locator searchTxt = new Locator(How.XPATH, "//input[@id='s']");


    public boolean doesHomePageDisplayed(){
        String homePageTitle = getTitle();
        if (homePageTitle.equals("Automation Practice Site")) {
            return true;
        }
        return false;
    }
    public void addAProductToCartByProductName(ProductModel productModel){
        Locator realProductAddToBasketBtn = new Locator(How.XPATH, productItemLocation.replace("{0}",productModel.ProductName));
        click(realProductAddToBasketBtn.getBy());
    }
    public void goToCart() {
        //click(cartBtn.getBy());
        clickByJavaScript(cartBtn.getBy());
        clickByJavaScript(cartBtn.getBy());
    }
    public void searchByKeyword(String keyword){
        click(searchTxt.getBy());
        clearField(searchTxt.getBy());
        enter(searchTxt.getBy(), keyword);
        pressEnterKey(searchTxt.getBy());
    }
}
