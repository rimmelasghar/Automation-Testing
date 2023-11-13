package org.example.Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Method {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public Method(WebDriver driver,WebDriverWait webDriverWait){
        this.driver = driver;
        this.wait = webDriverWait;
    }
    public static void navigateToUrl(String url){
        driver.get(url);
    }
    public static void verifyTitle(String expectedTitle){
        String actualTitle = driver.getTitle();
        assert expectedTitle.equals(actualTitle);
        System.out.println("Verified");
    }
    public static void enterText(String identifier,String inputText){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identifier)));
        element.sendKeys(inputText);
    }
    public static void clickElement(String identifier){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identifier)));
        element.click();
    }
    public static void closeSession(){
        driver.quit();
    }
    public static void verifyExpectedText(String identifier,String expectedText){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identifier)));
        String actualText = element.getText();
        assert expectedText.equals(actualText);
    }
}
