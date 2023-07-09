/**
 ** Author: Esakkivignesh **
 ** Description: Test Runner Class for UI Explorer **
 **/

package org.demo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.demo.utils.GenericUtils.*;

@CucumberOptions(tags = "", features = {"src/test/resources/features/UIExplorer.feature"},
        glue = {"org.demo.steps"}, monochrome =true,
        plugin = {"pretty",
                "html:./reports/cucumber-reports/cucumber-html/index.html",
                "rerun:target/failedrerun.txt"})
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {

    public static WebDriver driver;

    @BeforeTest
    public void setup() throws Exception {
        try {
            driver = openBrowser("chrome");
            implicitWait(driver, 20);
        } catch(Exception e) {
            throw new Exception("Exception occurred during test setup : " + e.getMessage());
        }
    }

    @Test
    public void runCucumberTests(){
    }

    @AfterTest
    public void tearDown() throws Exception {
        try {
            closeBrowser(driver);
        } catch(Exception e) {
            throw new Exception("Exception occurred during test closure : " + e.getMessage());
        }
    }
}
