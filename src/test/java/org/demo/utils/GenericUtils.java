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

    public WebDriver driver;
    public WebElement element;

    public WebDriver openBrowser(String browser)
    {
        switch(browser){
            case "chrome":
                driver = new ChromeDriver();
            case "firefox":
                driver = new FirefoxDriver();
            case "edge":
                driver = new EdgeDriver();
        }
        System.out.println("Opened browser - " + browser);
        return driver;
    }

    public void closeBrowser(WebDriver driver)
    {
        driver.close();
        System.out.println("Closed the browser");
    }

    public By getLocator(String type, String value)
    {
        By locator = null;
        switch(type)
        {
            case "id":
                locator = By.id(value);
            case "name":
                locator = By.name(value);
            case "className":
                locator = By.className(value);
            case "tagName":
                locator = By.tagName(value);
            case "xpath":
                locator = By.xpath(value);
            case "cssSelector":
                locator = By.cssSelector(value);
            case "linkText":
                locator = By.linkText(value);
            case "partialLinkText":
                locator = By.partialLinkText(value);
        }
        return locator;
    }

    public WebElement findElement(WebDriver driver, By locator)
    {
        element = driver.findElement(locator);
        return element;
    }

    public void implicitWait(WebDriver driver, int durationInSec)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(durationInSec));
        System.out.println("Applied implicit wait");
    }

    public void sleep(long durationInMillis) throws InterruptedException {
        Thread.sleep(durationInMillis);
        System.out.println("Execution under sleep for " + (durationInMillis / 1000) + " seconds");
    }

    public void waitUntilPresenceOfElement(WebDriver driver, Duration durationInSec,
                                    By locator, String condition)
    {
        WebDriverWait wait = new WebDriverWait(driver, durationInSec);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        System.out.println("Element found after explicit wait condition");
    }

    


}