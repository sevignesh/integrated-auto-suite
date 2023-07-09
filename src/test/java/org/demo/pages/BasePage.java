/**
 ** Author: Esakkivignesh **
 ** Description: Base Page file based on PageFactory POM Design Pattern **
 **/

package org.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
