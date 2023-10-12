package org.example.SwagsLabsTesting;
import org.example.Driver;
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
        WebDriver driver = driverObj.getDriver("FIREFOX");

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
        String itemName = null;
        String itemDescription = null;
        String itemPrice = null;

        List<WebElement> inventoryItems = driver.findElements(By.cssSelector("div.inventory_item"));
        if (!inventoryItems.isEmpty()) {
            WebElement firstItem = inventoryItems.get(0);
            itemName = firstItem.findElement(By.className("inventory_item_name")).getText();
            itemDescription = firstItem.findElement(By.className("inventory_item_desc")).getText();
            itemPrice = firstItem.findElement(By.className("inventory_item_price")).getText();

            WebElement addToCartBtn = firstItem.findElement(By.xpath("//button[contains(., 'Add to cart')]"));
            addToCartBtn.click();
        } else {
            System.out.println("No inventory items found.");
        }

        WebElement cartBtn = driver.findElement(By.className("shopping_cart_link"));
        cartBtn.click();

        String cartItemName = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        String cartItemDescription = driver.findElement(By.xpath("//div[@class='inventory_item_desc']")).getText();
        String cartItemPrice = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();

        System.out.println("<--- Add to Cart Test: Status --->");
        if (driver.getCurrentUrl().contains("cart.html") && itemName.equals(cartItemName)
                && itemDescription.equals(cartItemDescription) && itemPrice.equals(cartItemPrice)) {
            System.out.println("Verified Item Details in Cart Section Successful!");
            System.out.println("Add to Cart successful!");
        } else {
            System.out.println("Add to Cart failed!");
        }

        WebElement checkoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
        checkoutBtn.click();

        WebElement checkOutFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
        checkOutFirstName.sendKeys(parameter.checkoutUserFirstName);

        WebElement checkOutLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName")));
        checkOutLastName.sendKeys(parameter.checkoutUserLastName);

        WebElement checkOutPostalCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("postalCode")));
        checkOutPostalCode.sendKeys(parameter.checkoutPostalCode);

        WebElement continueBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue")));
        continueBtn.click();

        WebElement finishBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        finishBtn.click();

        System.out.println("<--- Check0ut Test: Status --->");
        if (driver.getCurrentUrl().contains("checkout-complete.html")) {
            System.out.println("Check-out successful!");
        } else {
            System.out.println("Check-out failed!");
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
