package models;

import java.util.Map;

public class BillingDetailsModel {
    public String FirstName;
    public String LastName;
    public String CompanyName;
    public String EmailAddress;
    public String Phone;
    public String Country;
    public String Address;
    public String PostcodeZip;
    public String TownCity;
    public String OrderNotes;
    public String PaymentMethod;

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setPostcodeZip(String postcodeZip) {
        PostcodeZip = postcodeZip;
    }

    public void setTownCity(String townCity) {
        TownCity = townCity;
    }

    public void setOrderNotes(String orderNotes) {
        OrderNotes = orderNotes;
    }
    public void setPaymentMethod(String paymentMethod){
        PaymentMethod = paymentMethod;
    }

    public static BillingDetailsModel addBillingDetails(Map<String, String> entry){
        BillingDetailsModel billingDetailsModel = new BillingDetailsModel();
        billingDetailsModel.setFirstName(entry.get("FirstName"));
        billingDetailsModel.setLastName(entry.get("LastName"));
        billingDetailsModel.setCompanyName(entry.get("CompanyName"));
        billingDetailsModel.setEmailAddress(entry.get("EmailAddress"));
        billingDetailsModel.setPhone(entry.get("Phone"));
        billingDetailsModel.setCountry(entry.get("Country"));
        billingDetailsModel.setAddress(entry.get("Address"));
        billingDetailsModel.setPostcodeZip(entry.get("PostcodeZip"));
        billingDetailsModel.setTownCity(entry.get("TownCity"));
        billingDetailsModel.setOrderNotes(entry.get("OrderNotes"));
        billingDetailsModel.setPaymentMethod(entry.get("PaymentMethod"));
        return billingDetailsModel;
    }
}
