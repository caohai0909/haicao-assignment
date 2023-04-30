package core.common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import static core.common.Constant.SHORT_TIMEOUT;
import static core.common.Constant.WEBDRIVER;


public class BuiltInAction {

    public static void maximizeWindow() {
        try {
            WEBDRIVER.manage().window().maximize();
        } catch (Exception err) {
            System.out.println("Error maximizeWindow: \n" + err);
            close();
        }
    }

    public static void visitPage(String url) {
        try {
            WEBDRIVER.get(url);
        } catch (Exception err) {
            System.out.println("Error Load new web page: \n" + err);
            close();
        }
    }

    public static void navigateTo(String url) {
        try {
            WEBDRIVER.navigate().to(url);
        } catch (Exception err) {
            System.out.println("Error Navigate By URL: \n" + err);
            close();
        }
    }

    public static String getCurrentUrl() {
        try {
            return WEBDRIVER.getCurrentUrl();
        } catch (Exception err) {
            System.out.println("Error Get Current URL: \n" + err);
            return null;
        }
    }

    public static WebElement getWebElement(By locator) {
        try {
            return WEBDRIVER.findElement(locator);
        } catch (Exception err) {
            System.out.println("Error Get element: \n" + err);
            return null;
        }
    }

    public static List<WebElement> getAllWebElements(By locator) {
        try {
            return WEBDRIVER.findElements(locator);
        } catch (Exception err) {
            System.out.println("Error Get All Element: \n" + err);
            return null;
        }
    }

    public static String getTitle() {
        try {
            return WEBDRIVER.getTitle();
        } catch (Exception err) {
            System.out.println("Error Get Title: \n" + err);
            return null;
        }
    }
    public static void enter(By locator, String contents) {
        try {
            waitForElement(locator, SHORT_TIMEOUT);
            Objects.requireNonNull(getWebElement(locator)).sendKeys(contents);
        } catch (Exception error) {
            System.out.println("Error Enter the value: " + error);
        }
    }
    public static void quit() {
        if (WEBDRIVER != null) {
            WEBDRIVER.quit();
        }
    }
    public static void close() {

        if (WEBDRIVER != null) {
            WEBDRIVER.close();
        }
    }
    public static void waitForElement(By locator, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(WEBDRIVER, timeoutInSeconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception err) {
            System.out.println("Error waitForElement : \r\n" + err);
        }
    }

    public static void waitForElementInVisible(By locator, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(WEBDRIVER, timeoutInSeconds);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception err) {
            System.out.println("Error waitForElement : \r\n" + err);
        }
    }

    public static void click(By locator) {
        waitForElement(locator, SHORT_TIMEOUT);
        try {
            Objects.requireNonNull(getWebElement(locator)).click();
        } catch (Exception err) {
            System.out.println("Error Click Element : " + err);
        }
    }
    public static void pressEnterKey(By locator){
        try {
            waitForElement(locator,SHORT_TIMEOUT);
            Objects.requireNonNull(getWebElement(locator)).sendKeys(Keys.ENTER);
        } catch (Exception err){
            System.out.println("Error Press ENTER Key: " + err);
        }
    }
    public static void clickByJavaScript(By locator){
        try {
            waitForElement(locator, SHORT_TIMEOUT);
            JavascriptExecutor executor = (JavascriptExecutor)WEBDRIVER;
            executor.executeScript("arguments[0].click();", getWebElement(locator));
        }catch (Exception err) {
            System.out.println("Error Click Element By JavaScript: \r\n" + err);
        }
    }

    public static void clearField(By locator) {
        try {
            Objects.requireNonNull(getWebElement(locator)).clear();
        } catch (Exception err) {
            System.out.println("Error Clear Element : \r\n" + err);
        }
    }

    public static void select(By locator, String selectBy, String value) {
        try {
            waitForElement(locator, SHORT_TIMEOUT);
            Select dropdown = new Select(Objects.requireNonNull(getWebElement(locator)));
            if (Objects.equals(selectBy, "index")) {
                dropdown.selectByIndex(Integer.parseInt(value));
            } else if (Objects.equals(selectBy, "value")) {
                dropdown.selectByValue(value);
            } else if (Objects.equals(selectBy, "text")) {
                dropdown.selectByVisibleText(value);
            } else {
                System.out.println("Cannot define!");
            }
        } catch (Exception err) {
            System.out.println("Error Select item : \n" + err);
        }
    }

    public static String getText(By locator) {
        try {
            return Objects.requireNonNull(getWebElement(locator)).getText();
        } catch (Exception err) {
            System.out.println("Error Get Element Text : \n" + err);
            return null;
        }
    }
    public static String getElementAttribute(By locator, String attribute) {
        try {
            return Objects.requireNonNull(getWebElement(locator)).getAttribute(attribute);
        } catch (Exception err) {
            System.out.println("Error Get Element Attribute : \n" + err);
            return null;
        }
    }

    public static boolean doesControlExist(By locator) {
        try {
            waitForElement(locator, SHORT_TIMEOUT);
            return Objects.requireNonNull(getWebElement(locator)).isDisplayed();
        } catch (Exception err) {
            System.out.println("Error Get Element Attribute : \n" + err);
            return false;
        }
    }

    public static void checkControlExist(By locator) {
        try {
            Boolean realLocator = Objects.requireNonNull(getWebElement(locator)).isDisplayed();
            if (realLocator == true) {
                System.out.println("Control is existed: " + locator);
            }
        } catch (Exception err) {
            System.out.println("Error checkControlExist : \n" + err);
            close();
        }
    }
    public static boolean isAttributeExist(By locator, String attribute) {
        Boolean result = false;
        try {
            String value = Objects.requireNonNull(getWebElement(locator)).getAttribute(attribute);
            if (value != null) {
                result = true;
            }
        } catch (Exception err) {
            System.out.println("Error is Attribute Exist: \n" + err);
        }
        return result;
    }
    public static void dragAndDrop(By source, By destination) {
        try {
            waitForElement(source,SHORT_TIMEOUT);
            waitForElement(destination,SHORT_TIMEOUT);
            Actions act = new Actions(WEBDRIVER);
            act.dragAndDrop(getWebElement(source), getWebElement(destination)).build().perform();
        } catch (Exception err) {
            System.out.println("Error dragAndDrop : \n" + err);
        }
    }
    public static void saveScreenShot(String path, String screenName) {
        try {
            File scrFile = ((TakesScreenshot) WEBDRIVER).getScreenshotAs(OutputType.FILE);
            String fullPath = path + screenName;
            FileUtils.copyFile(scrFile, new File(fullPath));
        } catch (Exception err) {
            System.out.println("Error saveScreenShot: \n" + err);
        }
    }
    public static void saveScreenShotEntirePage(String path, String screenName) {
        Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(WEBDRIVER);
        try {
            String fullPath = path + screenName;
            ImageIO.write(screenshot.getImage(),"PNG",new File(fullPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void attachFile(By location, String filePath) {
        try {
            waitForElement(location, SHORT_TIMEOUT.shortValue());
            Objects.requireNonNull(getWebElement(location)).sendKeys(filePath);
        } catch (Exception err) {
            System.out.println("Error attachFile: \n" + err);
        }
    }
    public static void switchToIFrame(By location){
        try {
            waitForElement(location, SHORT_TIMEOUT);
            WEBDRIVER.switchTo().frame(getWebElement(location));
        } catch (Exception err){
            System.out.println("Error switch to iframe: \n" + err);
        }
    }
    public static String getProjectPath() {

        String projectPath = System.getProperty("user.dir");
        return projectPath;
    }
    public static void scrollByVisibleElement(By location){
        JavascriptExecutor js = (JavascriptExecutor) WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView();", getWebElement(location));
    }
}
