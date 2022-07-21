package com.qa.mrs.keyword.engine;

import com.qa.mrs.keyword.base.Base;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class KeywordEngine {
    public static Workbook book; // interface reference
    public static Sheet sheet;
    public final String SCENARIO_SHEET_PATH = System.getProperty("user.dir") + "/src/main/java/com/qa/mrs/keyword/scenarios/openmrs_scenarios.xlsx";
    public WebDriver driver;
    public Properties prop;
    public Base base;
    public WebElement element;

    public void startExecution(String sheetName) {
        String locatorName = null;
        String locatorValue = null;

        FileInputStream file = null;
        try {
            file = new FileInputStream(SCENARIO_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // getting sheet name
        sheet = book.getSheet(sheetName);

//        for traversing through excel sheet
        int k = 0;
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            // i = 0 so for second column we are using i+1 to access id
            // maintaining counter i for row and counter k for column
            try {
                locatorName = sheet.getRow(i + 1).getCell(k + 1).toString().trim(); // get locator name
                locatorValue = sheet.getRow(i + 1).getCell(k + 2).toString().trim(); // get locator value

                String action = sheet.getRow(i + 1).getCell(k + 3).toString().trim();
                String value = sheet.getRow(i + 1).getCell(k + 4).toString().trim();

                // if the locator is present against an action we will cater it in switch locator
                switch (action) {
                    case "open browser":
                        base = new Base();
                        prop = base.init_properties();
                        // take browser name from config if it is not written in excel file
                        if (value.isEmpty() || value.equalsIgnoreCase("NA")) {
                            driver = base.init_driver(prop.getProperty("browser"));
                        } else {
                            driver = base.init_driver(value);
                        }
                        break;

                    case "enter url":
                        if (value.isEmpty() || value.equalsIgnoreCase("NA")) {
                            driver.get(prop.getProperty("url"));
                        } else {
                            driver.get(value);
                        }
                        break;

                    case "quit":
                        driver.quit();
                        break;
                    default:
                        break;
                }

                switch (locatorName) {
                    case "id":
                        element = driver.findElement(By.id(locatorValue));
                        if (action.equalsIgnoreCase("sendkeys")) {
                            element.clear();
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element is " + elementText);
                        }
                        locatorName = null;
                        break;

                    case "xpath":
                        element = driver.findElement(By.xpath(locatorValue));
                        if (action.equalsIgnoreCase("senkeys")) {
                            element.clear();
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element is " + elementText);
                            Assert.assertEquals(elementText, value);
                        }
                        locatorName = null;
                        break;
                    case "className":
                        element = driver.findElement(By.className(locatorValue));
                        if (action.equalsIgnoreCase("senkeys")) {
                            element.clear();
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element is " + elementText);
                        }
                        locatorName = null;
                        break;

                    case "name":
                        element = driver.findElement(By.name(locatorValue));
                        if (action.equalsIgnoreCase("senkeys")) {
                            element.clear();
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element is " + elementText);
                        }
                        locatorName = null;
                        break;

                    case "cssSelector":
                        element = driver.findElement(By.cssSelector(locatorValue));
                        if (action.equalsIgnoreCase("senkeys")) {
                            element.clear();
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element is " + elementText);
                        }
                        locatorName = null;
                        break;
                    case "linkText":
                        element = driver.findElement(By.linkText(locatorValue));
                        element.click();
                        locatorName = null;
                        break;
                    case "partialLinkText":
                        element = driver.findElement(By.partialLinkText(locatorValue));
                        element.click();
                        locatorName = null;
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Exception " + e.getMessage());
            }
        }


    }
}
