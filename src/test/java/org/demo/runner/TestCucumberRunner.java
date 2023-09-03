/**
 ** Author: Esakkivignesh **
 ** Description: Test Runner Class for UI Explorer **
 **/

package org.demo.runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.*;
import org.demo.utils.ListenerUtils;
import org.demo.utils.PropertiesReader;
import org.demo.utils.RetryAnalyzer;
import org.demo.utils.TestAnnotationTransformer;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.util.Properties;
import static org.demo.utils.GenericUtils.*;

@CucumberOptions(tags = "", features = {"src/test/resources/features/UIExplorer.feature"},
        glue = {"org.demo.steps"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true, publish = true)
@Listeners(ListenerUtils.class)
public class TestCucumberRunner extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;
    public static WebDriver driver;
    public static Properties prop;
    public static ExtentSparkReporter reporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void init() throws Exception {
        try {
            prop = new PropertiesReader().loadProperties("config.properties");
            /*
            reporter = new ExtentSparkReporter("extentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
            */
        } catch(Exception e) {
            throw new Exception("Exception occurred during initiating test suite : " + e.getMessage());
        }
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @BeforeTest
    public void setup(ITestContext context) throws Exception {
        try {
            driver = openBrowser(prop.getProperty("browser"));
            implicitWait(driver, 20);
        } catch(Exception e) {
            throw new Exception("Exception occurred during test setup : " + e.getMessage());
        }
    }

    @SuppressWarnings("unused")
    @Test(groups = "cucumber", description = "Run Cucumber Scenarios", dataProvider = "scenarios",
            retryAnalyzer = RetryAnalyzer.class)
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        // String featureName = featureWrapper.toString();
        // String scenarioName = pickleWrapper.getPickle().getName();
        // test = extent.createTest(featureName, scenarioName);
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        if (testNGCucumberRunner == null) {
            return new Object[0][0];
        }
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterTest
    public void tearDown() throws Exception {
        try {
            closeBrowser(driver);
        } catch(Exception e) {
            throw new Exception("Exception occurred during test closure : " + e.getMessage());
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (testNGCucumberRunner == null) {
            return;
        }
        testNGCucumberRunner.finish();
    }

    @AfterSuite
    public void clear() throws Exception {
        try {
            prop.clear();
            // extent.flush();
        } catch(Exception e) {
            throw new Exception("Exception occurred during initiating test suite : " + e.getMessage());
        }
    }

}
