package steps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.BillingDetailsModel;
import java.util.List;
import models.ProductModel;
import models.SearchProductModel;
import org.testng.Assert;
import pages.ecommerce.*;
import java.util.Map;
import static core.common.BuiltInAction.*;
import static core.common.Constant.ECOMMERCE_URL;

public class EcommerceSteps {
    HomePage homePage = new HomePage();
    BasketPage basketPage = new BasketPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    OrderReceivedPage orderReceivedPage = new OrderReceivedPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();

    @DataTableType
    public ProductModel convertProduct(Map<String, String> entry) {
        return ProductModel.addProduct(entry);
    }
    @DataTableType
    public BillingDetailsModel convertBillingDetails(Map<String, String> entry) {
        return BillingDetailsModel.addBillingDetails(entry);
    }
    @DataTableType
    public SearchProductModel convertSearchProduct(Map<String, String> entry){
        return SearchProductModel.searchProductByKeyword(entry);
    }
    @Given("I went to shop page")
    public void iWentToShopPage(){
        visitPage(ECOMMERCE_URL);
        maximizeWindow();

        Boolean doesHomePageDisplayed = homePage.doesHomePageDisplayed();
        Assert.assertTrue(doesHomePageDisplayed, "Failed to go to home page");
    }
    @When("I add product to cart")
    public void iAddProductToCart(List< ProductModel > table){
        table.forEach((ProductModel product)-> {
            homePage.addAProductToCartByProductName(product);
        });
    }
    @And("I go to cart")
    public void iGoToCart() {
        homePage.goToCart();

        Boolean doesBasketPageDisplayed = basketPage.doesBasketPageDislayed();
        Assert.assertTrue(doesBasketPageDisplayed, "Failed to go to basket page");
    }
    @And("I process checkout")
    public void iProcessCheckout() {
        basketPage.clickToProceedCheckout();

        Boolean doesCheckoutPageDisplayed = checkoutPage.doesCheckouPageDisplayed();
        Assert.assertTrue(doesCheckoutPageDisplayed, "Failed to go to checkout page");
    }
    @And("I enter billing details")
    public void iEnterBillingDetails(List<BillingDetailsModel> table) throws InterruptedException {
        checkoutPage.addBillingDetails(table.stream().findFirst().get());
    }
    @And("I click to proceed order")
    public void iClickToProceedOrder(){
        checkoutPage.clickPlaceOrder();

        Boolean doesOrderReceivedPageDisplayed = orderReceivedPage.doesThanksMessageDisplayed();
        Assert.assertTrue(doesOrderReceivedPageDisplayed, "Failed to go to order received page");
    }
    @Then("Validation result via screenshot")
    public void validationResultViaScreenshot(){
        orderReceivedPage.doScreenShotOrder();
    }
    @And("I change product quantity")
    public void iChangeProductQuantity(List<ProductModel> table) {
        table.forEach((ProductModel product)-> {
            basketPage.updateProductQuantityByProductName(product);
            Assert.assertTrue(basketPage.doesPerProductSubtotalCalculatedCorrectly(product), "Failed to calculated product subtotal");
        });
    }
    @Then("validation that total price is changing and reflecting correct price")
    public void validationThatTotalPriceIsChanging(){
        System.out.println("Already validated at step: [I change product quantity]");
    }
    @When("I search by keyword")
    public void iSearchByKeyword(List<SearchProductModel> table){
        table.forEach((SearchProductModel searchProduct)-> {
            homePage.searchByKeyword(searchProduct.Keyword);

            Boolean doesSearchResultDisplayed = searchResultsPage.doesRearechResultDispalyed(searchProduct.Results);
            Assert.assertTrue(doesSearchResultDisplayed, "Failed to Search By keyword: " + searchProduct.Results);
        });
    }
    @Then("Validation search results")
    public void validationSearchResults(){
        System.out.println("Already validated at step: [I search by keyword]");
    }
}
