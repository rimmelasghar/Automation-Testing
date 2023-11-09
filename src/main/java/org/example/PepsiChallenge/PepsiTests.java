package org.example.PepsiChallenge;

import org.example.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PepsiTests {
    public static String userNameValue = "Syed Muhammad Rimmel Asghar";
    public static String userPhoneNumber = "3322593149";
    public static String userEmailAddress = "rimmelasghar3@gmail.com";
    public static String userAddress = "R-1245 Block-14, Federal B Area, Karachi";
    public static int formEntries = 500;
    public static void main(String[] args) throws Exception {

        WebDriver driver = Driver.getDriver("CHROME");
        driver.get("https://cloud.email-pepsico.com/PepsiPromo2023-MainPage");

        WebDriverWait wait = new WebDriverWait(driver,5);

        for(int i=0;i<formEntries;i++){
            WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Name']")));
            userName.sendKeys(userNameValue);

            WebElement userNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='MobileNumber']")));
            userNumber.sendKeys(userPhoneNumber);

            WebElement emailAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='EmailAddress']")));
            emailAddress.sendKeys(userEmailAddress);

            WebElement addressPermanent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='Address']")));
            addressPermanent.sendKeys(userAddress);

            WebElement checkBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Consent']")));
            checkBox.click();

            WebElement checkBox1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='PrivacyPolicy']")));
            checkBox1.click();

            WebElement submitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='SubmitBtn']")));
            submitBtn.click();

            Thread.sleep(300);
            driver.navigate().back();
            driver.navigate().refresh();
        }
        System.out.println("Your Entries has been Done SuccessFully");
        driver.quit();

    }
}
