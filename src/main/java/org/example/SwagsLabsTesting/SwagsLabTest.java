package org.example.SwagsLabsTesting;
import org.example.Driver;
import org.example.Methods.Method;
import org.example.SwagsLabsTesting.pages.Login;
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
        method = new Method(driver,wait);

        Login login = new Login(method);
        login.loginTest();



//        Method.closeSession();
    }
}
