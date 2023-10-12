package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    public static WebDriver getDriver(String browserName) {
        WebDriver driver = null;
        String projectPath = System.getProperty("user.dir");
        switch (browserName.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", projectPath + "/src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                // default Driver is MicroSoft Edge
                System.setProperty("webdriver.edge.driver", projectPath + "/src/main/resources/msedgedriver.exe");
                driver = new EdgeDriver();
        }
        return driver;
    }
}
