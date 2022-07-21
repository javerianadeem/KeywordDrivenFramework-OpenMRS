package com.qa.mrs.keyword.base;

import com.qa.mrs.keyword.utilities.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base {

    public static WebDriver driver;

    public static WebDriver init_driver(String browserName) {
        if (browserName.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            if (new PropertyReader().readProperty("headless").equals("yes")) {
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
            } else {
                driver = new ChromeDriver();
            }
        } else if (browserName.equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            if (new PropertyReader().readProperty("headless").equals("yes")) {
                options.addArguments("--headless");
                driver = new FirefoxDriver(options);
            } else {
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }


}
