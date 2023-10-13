package org.example.GithubUserSearch;

import org.example.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GithubUserTests {

    public static void main(String[] args) throws InterruptedException {

        // Create a WebDriver instance (e.g., Chrome or Firefox)
        Driver driverObj = new Driver();
        WebDriver driver = driverObj.getDriver("FIREFOX");

        GithubUserParams params = new GithubUserParams();
        driver.get("https://gh-users-search.netlify.app/");

        // custom settings for Wait.
        WebDriverWait wait = new WebDriverWait(driver, 5);

        WebElement userSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid='search-bar']")));
        userSearch.sendKeys(params.githubUsername);

        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();

        List<WebElement> profileInfo = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//section[@class='sc-bcXHqe cSGkzu section-center']//h3")));
        String userRepositoryNumber = profileInfo.get(0).getText();
        String followerNumber = profileInfo.get(1).getText();
        String followingNumber = profileInfo.get(2).getText();

        driver.get("https://github.com/" + params.githubUsername);

        List<WebElement> verifyProfileInfo = driver.findElements(By.xpath("//span[@class='text-bold color-fg-default']"));
        String verifyFollowerNumber = verifyProfileInfo.get(0).getText();
        String verifyFollowingNumber = verifyProfileInfo.get(1).getText();

        String verifyRepositoryNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/" + params.githubUsername + "?tab=repositories']/span[@class='Counter']"))).getText();

        System.out.println("<--- Profile Verification Test: Status --->");
        if (verifyFollowerNumber.equals(followerNumber) && verifyFollowingNumber.equals(verifyFollowingNumber)
                && verifyRepositoryNumber.equals(userRepositoryNumber)) {
            System.out.println("Profile Followers : "+ verifyFollowerNumber);
            System.out.println("Profile Verification SuccessFull!");
        } else {
            System.out.println("Profile Verification Failed!");
        }
        driver.quit();
    }
}
