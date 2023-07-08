package org.demo.steps;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginSteps {

    @Given("^I open \"(.*)\" in \"(.*)\" browser$")
    public void i_open_in_browser(String url, String browser) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(url);
        driver.get(url);
        driver.close();
    }


}
