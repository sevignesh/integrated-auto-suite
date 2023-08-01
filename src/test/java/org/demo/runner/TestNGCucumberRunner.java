/**
 ** Author: Esakkivignesh **
 ** Description: Test Runner Class for UI Explorer **
 **/

package org.demo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.demo.utils.PropertiesReader;
import org.demo.utils.RetryAnalyzer;
import org.demo.utils.TestAnnotationTransformer;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.internal.annotations.ITest;
import java.lang.reflect.Method;
import java.util.Properties;

import static org.demo.utils.GenericUtils.*;

@CucumberOptions(tags = "", features = {"src/test/resources/features/UIExplorer.feature"},
        glue = {"org.demo.steps"}, monochrome =true,
        plugin = {"pretty",
                "html:./reports/cucumber-reports/cucumber-html/index.html",
                "rerun:target/failedrerun.txt"})
@Listeners(TestAnnotationTransformer.class)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {

    public static WebDriver driver;
    public static Properties prop;

    @BeforeSuite
    public void init() throws Exception {
        try {
            prop = new PropertiesReader().loadProperties("config.properties");

        } catch(Exception e) {
            throw new Exception("Exception occurred during initiating test suite : " + e.getMessage());
        }
    }

    @BeforeTest
    public void setup() throws Exception {
        try {
            driver = openBrowser(prop.getProperty("browser"));
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

    @AfterSuite
    public void clear() throws Exception {
        try {
            prop.clear();

        } catch(Exception e) {
            throw new Exception("Exception occurred during initiating test suite : " + e.getMessage());
        }
    }
}
