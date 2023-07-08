package org.demo.steps;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {

    @Given("I open {string} in {string} browser")
    public void i_open_in_browser(String url, String browser) {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.close();
    }


}
