package com.vytrack.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    //to not use elements directly in step definitions classes
    //helps to prevent code duplication and keep step definitions clean
    @FindBy(id = "prependedInput")
    private WebElement username;

    @FindBy(id = "prependedInput2")
    private WebElement password;

    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

}
