package models;

import java.util.Map;

public class UserRegistrationModel {
    public String FirstName;
    public String LastName;
    public String Phone;
    public String Country;
    public String City;
    public String EmailAddress;
    public String Gender;
    public String DaysOfWeek;
    public String BestTimeToContact;
    public String UploadFiles;

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastSalary) {
        LastName = lastSalary;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setDaysOfWeek(String daysOfWeek) {
        DaysOfWeek = daysOfWeek;
    }

    public void setBestTimeToContact(String bestTimeToContact) {
        BestTimeToContact = bestTimeToContact;
    }

    public void setUploadFiles(String uploadFiles) {
        UploadFiles = uploadFiles;
    }

    public static UserRegistrationModel createUserRegistration(Map<String, String> entry){
        UserRegistrationModel userRegistrationModel = new UserRegistrationModel();
        userRegistrationModel.setFirstName(entry.get("FirstName"));
        userRegistrationModel.setLastName(entry.get("LastName"));
        userRegistrationModel.setPhone(entry.get("Phone"));
        userRegistrationModel.setCountry(entry.get("Country"));
        userRegistrationModel.setCity(entry.get("City"));
        userRegistrationModel.setEmailAddress(entry.get("EmailAddress"));
        userRegistrationModel.setGender(entry.get("Gender"));
        userRegistrationModel.setDaysOfWeek(entry.get("DaysOfWeek"));
        userRegistrationModel.setBestTimeToContact(entry.get("BestTimeToContact"));
        userRegistrationModel.setUploadFiles(entry.get("UploadFiles"));
        return userRegistrationModel;
    }
}
