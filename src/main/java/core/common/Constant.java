package core.common;

import org.openqa.selenium.WebDriver;

public class Constant {

    public static WebDriver WEBDRIVER;
    public static final Integer LONG_TIMEOUT = 90;
    public static final Integer MEDIUM_TIMEOUT = 30;
    public static final Integer SHORT_TIMEOUT = 10;
    public static final String USER_REGISTRATION_URL = "https://testautomationpractice.blogspot.com/";
    public static final String ECOMMERCE_URL = "https://practice.automationtesting.in/";

    public static String API_BASE_URL = "http://restapi.adequateshop.com";
    public static String POST_USER_URL = API_BASE_URL + "/api/authaccount/registration";
    public static String GET_USER_URL = API_BASE_URL + "/api/users/{userId}";
    public static String PUT_USER_URL = API_BASE_URL + "/api/users/{userId}";
    public static String DELETE_USER_URL = API_BASE_URL + "/api/users/{userId}";
    public static String LOGIN_USER_URL = API_BASE_URL + "/api/authaccount/login";
}
