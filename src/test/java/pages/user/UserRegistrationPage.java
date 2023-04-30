package pages.user;

import core.locators.Locator;
import models.UserRegistrationModel;
import org.openqa.selenium.support.How;
import static core.common.BuiltInAction.*;
public class UserRegistrationPage {

    private Locator firstNameTxt = new Locator(How.XPATH, "//label[.='First Name']/following-sibling::input");
    private Locator lastNameTxt = new Locator(How.XPATH, "//label[.='Last Name']/following-sibling::input");
    private Locator phoneTxt = new Locator(How.XPATH, "//label[.='Phone']/following-sibling::input");
    private Locator countryTxt = new Locator(How.XPATH, "//label[.='Country']/following-sibling::input");
    private Locator cityTxt = new Locator(How.XPATH, "//label[.='City']/following-sibling::input");
    private Locator emailAddressTxt = new Locator(How.XPATH, "//label[.='Email Address']/following-sibling::input");
    public String genderLocation = "//label[.='{0}']";
    public String daysOfWeekLocation = "//label[.='{0}']";
    private Locator bestTimeToContactDrd = new Locator(How.XPATH, "//label[.='Best Time to Contact']/following-sibling::select");
    private Locator uploadFileBtn = new Locator(How.XPATH, "//input[@class='file_upload']");
    private Locator submitBtn = new Locator(How.XPATH, "//input[@id='FSsubmit']");
    private Locator frameIfr = new Locator(How.XPATH, "//iframe[@id=\"frame-one1434677811\"]");
    private Locator errorMgs = new Locator(How.XPATH, "//div[@class='segment_header' and text()=\"An error has occurred\"]");
    private Locator dragBox= new Locator(How.XPATH, "//div[@id='draggable']");
    private Locator dropBox = new Locator(How.XPATH, "//div[@id='droppable']");


    public boolean doesUserRegistrationPageDisplayed(){
        String homePageTitle = getTitle();
        if (homePageTitle.equals("Automation Testing Practice")) {
            return true;
        }
        return false;
    }
    public void volunteerSignUp(UserRegistrationModel userRegistrationModel){
        Locator realGenderRbn = new Locator(How.XPATH, genderLocation.replace("{0}", userRegistrationModel.Gender));
        switchToIFrame(frameIfr.getBy());
        enter(firstNameTxt.getBy(), userRegistrationModel.FirstName);
        enter(lastNameTxt.getBy(), userRegistrationModel.LastName);
        enter(phoneTxt.getBy(), userRegistrationModel.Phone);
        enter(countryTxt.getBy(), userRegistrationModel.Country);
        scrollByVisibleElement(cityTxt.getBy());
        enter(cityTxt.getBy(), userRegistrationModel.City);
        scrollByVisibleElement(emailAddressTxt.getBy());
        enter(emailAddressTxt.getBy(), userRegistrationModel.EmailAddress);
        scrollByVisibleElement(realGenderRbn.getBy());
        click(realGenderRbn.getBy());
        stickToDaysOfWeekAvailable(userRegistrationModel.DaysOfWeek);
        select(bestTimeToContactDrd.getBy(), "text", userRegistrationModel.BestTimeToContact);
        attachFile(uploadFileBtn.getBy(), getProjectPath()+ userRegistrationModel.UploadFiles);
    }
    public void stickToDaysOfWeekAvailable(String daysOfWeekList){
        String[] words = daysOfWeekList.split(";");
        for (String day: words){
            Locator realDaysOfWeekCbx = new Locator(How.XPATH, daysOfWeekLocation.replace("{0}", day));
            scrollByVisibleElement(realDaysOfWeekCbx.getBy());
            click(realDaysOfWeekCbx.getBy());
        }
    }
    public void clickToSubmitButton(){
        click(submitBtn.getBy());
    }
    public boolean doesErrorMessageIsDisplayed(){
        return doesControlExist(errorMgs.getBy());
    }
    public void dragAndDropDemonstrate(){
        dragAndDrop(dragBox.getBy(), dropBox.getBy());
    }
    public boolean doesDragAndDropSuccessfully(){
        String dropped = getText(dropBox.getBy());
        if(dropped.equals("Dropped!")){
            return true;
        }
        return false;
    }
    public void enterInvalidEmailAddress(String invalidEmail){
        switchToIFrame(frameIfr.getBy());
        scrollByVisibleElement(emailAddressTxt.getBy());
        enter(emailAddressTxt.getBy(), invalidEmail);
        pressEnterKey(emailAddressTxt.getBy());
    }
    public String doesInvalidEmailMessageDisplayed(){

        return getElementAttribute(emailAddressTxt.getBy(), "validationMessage");
    }

}
