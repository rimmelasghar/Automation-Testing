package org.example.Labs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Params {
    //    Parameters for SwagsLab Website.
    public static WebDriver driver;
    public static int waitTime = 5;
    public static String projectPath = System.getProperty("user.dir");
    public static String userName = "standard_user";
    public static String userPassword = "secret_sauce";
    public static String checkoutUserFirstName = "Rimmel";
    public static String checkoutUserLastName = "Asghar";
    public static String checkoutPostalCode = "45372";
    public static String urlPath = "https://www.saucedemo.com/";
    public static String expectedTitle = "Swag Labs";
    public  static String userNameIdentifier = "user-name";
    public  static String userPasswordIdentifier = "password";
    public  static String loginBtnIdentifier = "login-button";
    public  static  String productIdentifier = "//span[@class='title']";
    public  static  String expectedProductResults = "Products";

    public static void waitForTime(int ms) throws Exception {
        Thread.sleep(ms);
    }

    public static void getDriverSession() {
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void navigateToUrl(String url) {
        driver.get(url);
    }
    public static void verifyTitle() {
        String actualTitle = driver.getTitle();
        try {
            if (actualTitle.equals(expectedTitle)) {
                System.out.println("Test Passed --> ");
            } else {
                System.out.println("Test Unsuccessfull -->");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void enterText(String identifier,String testData) throws Exception{
        try {
            WebElement element = driver.findElement(By.name(identifier));
            element.sendKeys(testData);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static void clickElement(String identifier) throws Exception{
        try{
            WebElement element = driver.findElement(By.id(identifier));
            element.click();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void closeAndQuitDriverSession(){
        driver.close();
        driver.quit();
    }
    public static void verifyElementExpectedText(String identifier,String expectedText) throws Exception{
        try{
            WebElement element = driver.findElement(By.xpath(identifier));
            String actualText = element.getText();
            if (actualText.equals(expectedText)){
                System.out.println("Test Passed -->");
            } else {
                System.out.println("Test Failed");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {
        // <--- WorkFlow:: --->
        getDriverSession();
        navigateToUrl(urlPath);
        waitForTime(3);
        verifyTitle();
        enterText(userNameIdentifier,userName);
        enterText(userPasswordIdentifier,userPassword);
        clickElement(loginBtnIdentifier);
        waitForTime(3);
        verifyElementExpectedText(productIdentifier,expectedProductResults);
        closeAndQuitDriverSession();
    }
}
