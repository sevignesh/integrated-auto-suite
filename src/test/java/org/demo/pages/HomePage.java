package org.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {


    @FindBy(linkText="CheckBoxes")
    WebElement checkBoxes;

    public HomePage(WebDriver driver){
        super(driver);
    }


}
