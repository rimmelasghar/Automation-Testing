package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class SwagsLabTest {
    public static void main(String[] args) {

        //  Driver Setup
        Driver driverObj = new Driver();
        WebDriver driver = driverObj.getDriver("EDGE");

        // Params Setup
        Params parameter = new Params();

        driver.get("https://www.saucedemo.com/");

        // custom settings for Wait.
        WebDriverWait wait = new WebDriverWait(driver, 5);

        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user-name")));
        userName.sendKeys(parameter.userName);

        WebElement userPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        userPassword.sendKeys(parameter.userPassword);

        WebElement button = driver.findElement(By.id("login-button"));
        button.click();

        System.out.println("<--- Login Test: Status --->");
        if (driver.getCurrentUrl().contains("inventory.html")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }

        List<WebElement> inventoryItems = driver.findElements(By.cssSelector("div.inventory_item"));
        if (!inventoryItems.isEmpty()) {
            WebElement firstItem = inventoryItems.get(0);
            String firstItemText = firstItem.getText();
            System.out.println("Text of the first element: " + firstItemText);

            WebElement addToCartBtn = firstItem.findElement(By.xpath("//button[contains(., 'Add to cart')]"));
            addToCartBtn.click();
        } else {
            System.out.println("No inventory items found.");
        }

        WebElement cartBtn = driver.findElement(By.className("shopping_cart_link"));
        cartBtn.click();

        System.out.println("<--- Add to Cart Test: Status --->");
        if (driver.getCurrentUrl().contains("cart.html")) {
            System.out.println("Add to Cart successful!");
        } else {
            System.out.println("Add to Cart failed!");
        }

        WebElement menuBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-menu-btn")));
        menuBtn.click();

        WebElement logOutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        logOutBtn.click();

        System.out.println("<--- LogOut Test: Status --->");
        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/")) {
            System.out.println("Log-out successful!");
        } else {
            System.out.println("Log-out failed!");
        }

        // Close the browser.
        driver.quit();
    }
}
