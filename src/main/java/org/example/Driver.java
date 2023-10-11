package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    public static WebDriver getDriver(String browserName) {
        WebDriver driver = null;

        switch (browserName.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:/Users/840 G3/Desktop/Folders/SeleniumTesting/TestingSQA/src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:/Users/840 G3/Desktop/Folders/SeleniumTesting/TestingSQA/src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                // default Driver is MicroSoft Edge
                System.setProperty("webdriver.edge.driver", "C:/Users/840 G3/Desktop/Folders/SeleniumTesting/TestingSQA/src/main/resources/msedgedriver.exe");
                driver = new EdgeDriver();
        }
        return driver;
    }
}
