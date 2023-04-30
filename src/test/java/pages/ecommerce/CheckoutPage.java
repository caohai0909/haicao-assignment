package pages.ecommerce;

import core.locators.Locator;
import models.BillingDetailsModel;
import org.openqa.selenium.support.How;
import static core.common.BuiltInAction.*;
import static core.common.BuiltInAction.scrollByVisibleElement;

public class CheckoutPage {
    private Locator firstNameTxt = new Locator(How.XPATH, "//input[@id='billing_first_name']");
    private Locator lastNameTxt = new Locator(How.XPATH, "//input[@id='billing_last_name']");
    private Locator companyNameTxt = new Locator(How.XPATH, "//input[@id='billing_company']");
    private Locator emailAddressTxt = new Locator(How.XPATH, "//input[@id='billing_email']");
    private Locator phoneTxt = new Locator(How.XPATH, "//input[@id='billing_phone']");

    private Locator countryDrd = new Locator(How.XPATH, "//p[@id='billing_country_field']");
    private Locator searchCountryTxt = new Locator(How.XPATH, "//input[@id='s2id_autogen1_search']");

    private Locator addressTxt =  new Locator(How.XPATH, "//input[@id='billing_address_1']");
    private Locator postCodeZipTxt = new Locator(How.XPATH, "//input[@id='billing_postcode']");
    private Locator townCityTxt = new Locator(How.XPATH, "//input[@id='billing_city']");
    private Locator orderNotesTxt = new Locator(How.XPATH, "//textarea[@id='order_comments']");
    private Locator productOrderListLbl = new Locator(How.XPATH, "//th[@class='product-name']");
    private String paymentMethodLocation = "//label[contains(.,'{0}')]/preceding-sibling::input";
    private Locator placeOrderBtn = new Locator(How.XPATH, "//input[@id='place_order']");

    public boolean doesCheckouPageDisplayed(){
        String checkoutPageTitle = getTitle();
        if (checkoutPageTitle.equals("Checkout – Automation Practice Site")){
            return true;
        }
        return false;
    }
    public void addBillingDetails(BillingDetailsModel billingDetailsModel) throws InterruptedException {
        Locator realPaymentMethodRdo = new Locator(How.XPATH, paymentMethodLocation.replace("{0}", billingDetailsModel.PaymentMethod));
        enter(firstNameTxt.getBy(), billingDetailsModel.FirstName);
        enter(lastNameTxt.getBy(), billingDetailsModel.LastName);
        enter(phoneTxt.getBy(), billingDetailsModel.Phone);
        enter(companyNameTxt.getBy(), billingDetailsModel.CompanyName);
        enter(emailAddressTxt.getBy(), billingDetailsModel.EmailAddress);
        enter(addressTxt.getBy(), billingDetailsModel.Address);
        enter(postCodeZipTxt.getBy(), billingDetailsModel.PostcodeZip);
        enter(townCityTxt.getBy(), billingDetailsModel.TownCity);
        scrollByVisibleElement(orderNotesTxt.getBy());
        enter(orderNotesTxt.getBy(), billingDetailsModel.OrderNotes);
        selectCountry(billingDetailsModel.Country);
        scrollByVisibleElement(productOrderListLbl.getBy());
        click(realPaymentMethodRdo.getBy());

    }
    public void clickPlaceOrder(){
        click(placeOrderBtn.getBy());
    }
    public void selectCountry(String country){
        click(countryDrd.getBy());
        enter(searchCountryTxt.getBy(), country);
        pressEnterKey(searchCountryTxt.getBy());
    }

}
