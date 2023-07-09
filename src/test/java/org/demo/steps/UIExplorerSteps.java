/**
** Author: Esakkivignesh **
** Description: Step Definition for UI Explorer test features **
**/

package org.demo.steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.demo.runner.FailedTestNGCucumberRunner;
import org.demo.runner.TestNGCucumberRunner;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import static org.demo.utils.GenericUtils.*;

public class UIExplorerSteps extends TestNGCucumberRunner {

    @Given("^I open the site \"(.*)\"$")
    public void i_open_the_site(String url) throws Exception {
        try {
            driver.get(url);
        } catch(Exception e) {
            throw new Exception("Exception occurred while opening the site : " + e.getMessage());
        }
    }

    @Given("^I click on \"(.*)\" link")
    public void i_click_on_link(String link) throws Exception {
        try {
            String locatorVal = "//a[text()='"+link+"']";
            findElement(driver, getLocator("xpath", locatorVal)).click();
            sleep(3000);
        } catch(Exception e) {
            throw new Exception("Exception occurred while opening the link : " + e.getMessage());
        }
    }

    @Given("^I got redirected to \"(.*)\" page")
    public void i_got_redirected_to_page(String pageTag) throws Exception {
        try {
            String expectedPage = "http://the-internet.herokuapp.com/" + pageTag;
            Assert.assertEquals(driver.getCurrentUrl(), expectedPage);
        } catch(Exception e) {
            throw new Exception("Exception occurred while redirecting to page : " + e.getMessage());
        }
    }

    @When("^I click checkbox \"(.*)\"")
    public void i_click_checkbox(String element) throws Exception {
        try {
            String locatorVal = "//input[" + element + "]";
            findElement(driver, getLocator("xpath", locatorVal)).click();
            sleep(3000);
        } catch(Exception e) {
            throw new Exception("Exception occurred while interacting with checkbox : " + e.getMessage());
        }
    }

    @When("^Checkbox \"(.*)\" should be \"(.*)\"")
    public void checkbox_should_be(String element, String option) throws Exception {
        try {
            String locatorVal = "//input[" + element + "]";
            boolean checkVal = findElement(driver, getLocator("xpath", locatorVal)).isSelected();
            if(option.equals("enabled"))
                Assert.assertEquals(checkVal, true);
            else
                Assert.assertEquals(checkVal, false);
        } catch(Exception e) {
            throw new Exception("Exception occurred while validating the checkbox : " + e.getMessage());
        }
    }

    @When("^I enter text as \"(.*)\"")
    public void i_enter_text_as(String val) throws Exception {
        try {
            findElement(driver, getLocator("xpath", "//input")).sendKeys(val);
            sleep(3000);
        } catch(Exception e) {
            throw new Exception("Exception occurred while interacting with textbox : " + e.getMessage());
        }
    }

    @When("^Input textbox should contain \"(.*)\"")
    public void input_textbox_should_contain(String expectedVal) throws Exception {
        try {
            WebElement ele = findElement(driver, getLocator("xpath", "//input"));
            String checkVal = ele.getAttribute("value");
            Assert.assertEquals(checkVal, expectedVal);
            ele.clear();
        } catch(Exception e) {
            throw new Exception("Exception occurred while validating the textbox : " + e.getMessage());
        }
    }



}
