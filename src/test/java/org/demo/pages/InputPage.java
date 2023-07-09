/**
 ** Author: Esakkivignesh **
 ** Description: Input Page file based on PageFactory POM Design Pattern **
 **/

package org.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InputPage extends BasePage {

    @FindBy(xpath = "//input")
    public WebElement inputBox;

    public InputPage(WebDriver driver){
        super(driver);
    }


}
