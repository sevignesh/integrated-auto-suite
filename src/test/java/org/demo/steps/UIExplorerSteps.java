package org.demo.steps;
import io.cucumber.java.en.Given;
import org.demo.pages.HomePage;
import org.demo.runner.TestNGCucumberRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class UIExplorerSteps extends TestNGCucumberRunner {

    @Given("^I open the site \"(.*)\"$")
    public void i_open_the_site(String url) {
        driver.get(url);
    }

    @Given("^I click on \"(.*)\" link")
    public void i_click_on_link(String link) {
        switch(link) {
            case "Checkboxes":
                System.out.println("Checkbox");
        }
    }


}
