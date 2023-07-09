/**
 ** Author: Esakkivignesh **
 ** Description: Common utility methods related to Selenium web interactions **
 **/

package org.demo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenericUtils {

    public static WebDriver driver;
    public static WebElement element;

    public static WebDriver openBrowser(String browser)
    {
        switch(browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
        }
        System.out.println("Opened browser - " + browser);
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeBrowser(WebDriver driver)
    {
        driver.close();
        System.out.println("Closed the browser");
    }

    public static By getLocator(String type, String value)
    {
        By locator = null;
        switch(type)
        {
            case "id":
                locator = By.id(value);
                break;
            case "name":
                locator = By.name(value);
                break;
            case "className":
                locator = By.className(value);
                break;
            case "tagName":
                locator = By.tagName(value);
                break;
            case "xpath":
                locator = By.xpath(value);
                break;
            case "cssSelector":
                locator = By.cssSelector(value);
                break;
            case "linkText":
                locator = By.linkText(value);
                break;
            case "partialLinkText":
                locator = By.partialLinkText(value);
                break;
        }
        return locator;
    }

    public static WebElement findElement(WebDriver driver, By locator)
    {
        element = driver.findElement(locator);
        return element;
    }

    public static void implicitWait(WebDriver driver, int durationInSec)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(durationInSec));
        System.out.println("Applied implicit wait");
    }

    public static void sleep(long durationInMillis) throws InterruptedException {
        Thread.sleep(durationInMillis);
        System.out.println("Execution under sleep for " + (durationInMillis / 1000) + " seconds");
    }

    public static void waitUntilPresenceOfElement(WebDriver driver, Duration durationInSec,
                                    By locator, String condition)
    {
        WebDriverWait wait = new WebDriverWait(driver, durationInSec);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        System.out.println("Element found after explicit wait condition");
    }




}
