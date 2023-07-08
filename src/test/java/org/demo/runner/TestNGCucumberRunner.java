package org.demo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.demo.utils.GenericUtils.*;

@CucumberOptions(tags = "", features = {"src/test/resources/features/UIExplorer.feature"},
        glue = {"org.demo.steps"},
        plugin = {})
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {

    public static WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = openBrowser("chrome");
        implicitWait(driver, 10);
    }

    @Test
    public void runCucumberTests(){
    }

    @AfterTest
    public void tearDown(){
        closeBrowser(driver);
    }
}
