package steps;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.UserRegistrationModel;
import org.testng.Assert;
import pages.user.UserRegistrationPage;
import java.util.List;
import java.util.Map;
import static core.common.BuiltInAction.*;
import static core.common.Constant.USER_REGISTRATION_URL;

public class UserRegistrationSteps {

    UserRegistrationPage userRegistrationPage = new UserRegistrationPage();
    String invalidEmail = "invalid email";
    @DataTableType
    public UserRegistrationModel convertUserRegistrationModel(Map<String, String> entry) {
        return UserRegistrationModel.createUserRegistration(entry);
    }

    @Given("I went to user registration page")
    public void iWentToUserRegistrationPage(){
        visitPage(USER_REGISTRATION_URL);
        maximizeWindow();
        System.out.println("I went to user registration page successfully");

        Boolean doesUserRegistrationPageDisplayed = userRegistrationPage.doesUserRegistrationPageDisplayed();
        Assert.assertTrue(doesUserRegistrationPageDisplayed, "Failed to go to user registration page");
    }
    @When("I enter all information in Volunteer Sign Up section")
    public void iEnterAllInformationInVolunteerSignUpSection(List<UserRegistrationModel> table) {
        userRegistrationPage.volunteerSignUp(table.stream().findFirst().get());
    }
    @And("I click to Submit button")
    public void iClickToSubmitButton(){
        userRegistrationPage.clickToSubmitButton();
    }
    @Then("Validate that user is created or failed to create")
    public void validationThatUserIsCreated(){
        boolean doesErrorMessageIsDisplayed = userRegistrationPage.doesErrorMessageIsDisplayed();
        Assert.assertFalse(doesErrorMessageIsDisplayed, "Failed to create volunteer because of error message!");
    }
    @When("I do drag and drop for demonstrate")
    public void iDoDragAndDropForDemonstrate(){
        userRegistrationPage.dragAndDropDemonstrate();
    }
    @Then("Validation drag and drop is successfully")
    public void validationDragAndDropIsSuccessfully(){
        boolean doesDragAndDropSuccessfully = userRegistrationPage.doesDragAndDropSuccessfully();
        Assert.assertTrue(doesDragAndDropSuccessfully, "Failed to drag and drop");
    }
    @When("I enter invalid to email address and click enter")
    public void iEnterInvalidEmailAddress(){
        userRegistrationPage.enterInvalidEmailAddress(invalidEmail);
    }
    @Then("Validation that invalid email error message is displayed")
    public void validationThatAnErrorMessageIsDisplayed(){
        String alertMgs = userRegistrationPage.doesInvalidEmailMessageDisplayed();
        Assert.assertEquals(alertMgs, "Please include an '@' in the email address. '" + invalidEmail +"' is missing an '@'.");
    }
}
