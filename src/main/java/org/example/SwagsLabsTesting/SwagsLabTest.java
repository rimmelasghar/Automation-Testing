package org.example.SwagsLabsTesting;
import org.example.Driver;
import org.example.Methods.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SwagsLabTest {
    public static SwagsLabParams params = new SwagsLabParams();
    public static WebDriverWait wait;
    public static Method method;
    public static void main(String[] args) {

        Driver driverObj = new Driver();
        WebDriver driver = driverObj.getDriver(params.browser);
        
        wait = new WebDriverWait(driver, params.waitTime);

        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user-name")));
        userName.sendKeys(parameter.userName);

        // Close the browser.
        driver.quit();
    }
}
