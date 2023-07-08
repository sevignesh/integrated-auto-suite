package org.demo.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/features/Login.feature"},
        glue = {"org.demo.steps"},
        plugin = {})
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {

}
