package com.base;

import com.utility.FileReaderManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Base_Class {
    public static WebDriver driver;

    protected static WebDriver launchBrowser(String browserName) {
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else {
                Assert.fail("ERROR : INVALID BROWSER NAME - " + browserName);
            }

            if (driver != null) {
                driver.manage().window().maximize();
            }
            return driver;

        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING BROWSER LAUNCH - " + e.getMessage());
            return null;
        }

    }
    protected static void wait(int seconds){
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            Assert.fail("ERROR : OCCUR DURING BROWSER WAIT");
        }
    }

    protected static void launchUrl(String url) {
        if (driver == null) {
            Assert.fail("ERROR : BROWSER NOT LAUNCHED. Call launchBrowser() first.");
        }
        try {
            driver.get(url);
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING URL LAUNCH - " + e.getMessage());
        }
    }
    protected  static void navigateBack(){
        try{
            driver.navigate().back();
        }catch(Exception e){
            Assert.fail("ERROR : OCCUR DURING NAVIGATE BACK");
        }
    }
    protected  static void navigateForward(){
        try{
            driver.navigate().forward();
        }catch(Exception e){
            Assert.fail("ERROR : OCCUR DURING NAVIGATE FORWARD");
        }
    }
    protected  static void refresh(){
        try{
            driver.navigate().refresh();
        }catch(Exception e){
            Assert.fail("ERROR : OCCUR DURING REFRESH");
        }
    }
    protected static void getCurrentUrl(){
        try{
            driver.getCurrentUrl();
        }catch (Exception e){
            Assert.fail("ERROR : OCCUR DURING GET CURRENT URL");
        }
    }
    protected static void getTitle(){
        try{
            driver.getTitle();
        }catch(Exception e){
            Assert.fail("ERROR : OCCUR DURING GET TITLE");
        }
    }
    protected static void getText(String text){
        try {
            String actualText = text;
            System.out.println("Actual Text: " + actualText);
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING GET TEXT");
        }

    }

    protected static void passInput(WebElement element, String value) {
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING PASSING VALUE");
        }
    }

    public static void clickOnElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING CLICKING");
        }
    }

    protected static void windowsHandling(int num) {
        try {
            List<String> allWindow = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(allWindow.get(num));
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING WINDOW HANDLING");
        }
    }


    protected static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING CLICK - " + e.getMessage());
        }
    }
    protected static void takeScreenshot(String fileName) {
        try {
            File screenshot = ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
            File destination = new File("screenshots/" + fileName + ".png");
            org.openqa.selenium.io.FileHandler.copy(screenshot, destination);
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING TAKING SCREENSHOT - " + e.getMessage());
        }

    }


    protected static boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING IS DISPLAYED - " + e.getMessage());
        }
        return false;
    }

    protected static void alertHandling(String message) {
        try {
            org.openqa.selenium.Alert alert = driver.switchTo().alert();
            if (message.equalsIgnoreCase("accept")) {
                alert.accept();
            } else if (message.equalsIgnoreCase("dismiss")) {
                alert.dismiss();
            } else if (message.equalsIgnoreCase("getText")) {
                alert.getText();
            }
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING ALERT HANDLING - " + e.getMessage());
        }
    }

    protected static void scrollUp(WebElement element){
        try {
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING SCROLL UP - " + e.getMessage());
        }

    }

    protected static void scrollDown(WebElement element){
        try{
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(false);", element);
        }catch (Exception e){
            Assert.fail("ERROR: OCCURRED DURING SCROLL DOWN - " + e.getMessage());
        }
    }

    protected static boolean isEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING IS ENABLED - " + e.getMessage());
        }
        return false;
    }
    protected static void selectOptions(WebElement element, String type, String value) {
        try {
            Select select = new Select(element);
            if (type.equalsIgnoreCase("text")) {
                select.selectByVisibleText(value);
            } else if (type.equalsIgnoreCase("index")) {
                select.selectByIndex(Integer.parseInt(value));
            } else if (type.equalsIgnoreCase("value")) {
                select.selectByValue(value);
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING SELECT OPTIONS");
        }
    }

    protected static void deSelectOptions(WebElement element, String type, String value) {
        try {
            Select select = new Select(element);
            if (type.equalsIgnoreCase("text")) {
                select.deselectByVisibleText(value);
            } else if (type.equalsIgnoreCase("index")) {
                select.deselectByIndex(Integer.parseInt(value));
            } else if (type.equalsIgnoreCase("value")) {
                select.deselectByValue(value);
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING DESELECT OPTIONS");
        }
    }
    protected static void closeBrowser(){
        try{
            driver.close();
        } catch(Exception e){
            Assert.fail("ERROR : OCCUR DURING CLOSE");
        }
    }
    protected static WebElement getFirstSelectedOption(WebElement dropdown) {
        try {
            Select select = new Select(dropdown);
            return select.getFirstSelectedOption();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING GETFRISTSELECTEDOPTION");
            return null;
        }
    }
    protected  static void browserTermination(){
        try{
            driver.quit();
        } catch (Exception e){
            Assert.fail("ERROR : OCCUR DURING BROWSER TERMINATION");
        }
    }

    protected static void jsExecutorMethods(WebDriver driver,String script, Objects... args){
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(script, (Object) args);

        }catch (Exception e){
            System.out.println("kishore");
            Assert.fail("ERROR : OCCURRED DURING JS EXECUTION");
        }
    }

}
