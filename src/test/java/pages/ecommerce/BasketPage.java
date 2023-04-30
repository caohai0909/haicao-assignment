package pages.ecommerce;
import core.locators.Locator;
import models.ProductModel;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import java.text.DecimalFormat;
import static core.common.BuiltInAction.*;
import static core.common.Constant.SHORT_TIMEOUT;

public class BasketPage {

    private Locator basketPageTlt = new Locator(How.XPATH, "//title[.='Basket – Automation Practice Site']");
    private Locator proceedToCheckoutBtn = new Locator(How.XPATH, "//a[contains(.,'Proceed to Checkout')]");
    private String productQuantityLocation = "//a[.='{0}']/parent::td/following-sibling::td//input[@class='input-text qty text']";
    private Locator updateBasketBtn = new Locator(How.XPATH, "//input[@name='update_cart']");
    private String perProductSubtotalLocation = "//a[.='{0}']/parent::td/following-sibling::td[@class='product-subtotal']//span[@class='woocommerce-Price-amount amount']";
    private Locator basketUpdatedMsg = new Locator(How.XPATH, "//div[@class='woocommerce-message' and text()='Basket updated.']");

    public boolean doesBasketPageDislayed(){
        String basketTitle = getTitle();
        if (basketTitle.equals("Basket – Automation Practice Site")){
            return true;
        }
        return false;
    }
    public void updateProductQuantityByProductName(ProductModel productModel){
        Locator realProductQuantityTxt = new Locator(How.XPATH, productQuantityLocation.replace("{0}", productModel.ProductName));
        clearField(realProductQuantityTxt.getBy());
        enter(realProductQuantityTxt.getBy(), productModel.ProductQuantity);
        click(updateBasketBtn.getBy());
    }
    public void clickToProceedCheckout(){
        click(proceedToCheckoutBtn.getBy());
    }
    public boolean doesPerProductSubtotalCalculatedCorrectly(ProductModel productModel) {
        Locator realPerProductSubtotalLbl = new Locator(How.XPATH, perProductSubtotalLocation.replace("{0}", productModel.ProductName));
        waitForElement(basketUpdatedMsg.getBy(), SHORT_TIMEOUT);
        String perProductSubtotalLbl = getText(realPerProductSubtotalLbl.getBy());
        perProductSubtotalLbl = perProductSubtotalLbl.substring(1);
        double productPrice = Double.parseDouble(productModel.ProductPrice);
        double quantity =  Double.parseDouble(productModel.ProductQuantity);
        double realSubtotal = productPrice*quantity;
        DecimalFormat df=new DecimalFormat("#,###.00");
        String formattedNumberWithComma = df.format(realSubtotal);
        if (formattedNumberWithComma.equals(perProductSubtotalLbl)){
            return true;
        }
        return false;
    }
}
