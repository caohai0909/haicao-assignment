package core.locators;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import static core.common.Constant.WEBDRIVER;


public class WebDriver {

    public static void openBrowser(String testBrowser)  {
//        try {
            switch (testBrowser) {
                case "Chrome":
                    WebDriverManager.chromedriver().setup();
                    WEBDRIVER = new ChromeDriver();
                    break;
                case "Firefox":
                    WebDriverManager.firefoxdriver().setup();
                    WEBDRIVER = new FirefoxDriver();
                    break;
                default:
                    System.out.println(testBrowser + " Can NOT define!");
            }
//        }catch (Exception e){
//            throw new RuntimeException(e);
//        }
    }
}
