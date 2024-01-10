package com.ferrovial.interfaceUI;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {
       
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    private static void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("w3c", false);
        options.addArguments("--remote-allow-origins=*, --no-sandbox-and-elevated, --disable-dev-shm-usage, --start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://adb-795588254297800.0.azuredatabricks.net/sql/dashboards/3b682712-ce34-4d56-b2ea-d4ac684f23c3?o=795588254297800");

    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
