package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import io.cucumber.java.en.Given;

public class CommonStepDefinitions {

    //created login page to gain access to base page method 'navigateTo'
    LoginPage loginPage = new LoginPage();

    // here {string} will represent tabName and {string2} will represent moduleName
    //module name is also links under tab
    @Given("user navigates to {string} and {string}")
    public void user_navigates_to_and(String string, String string2) {
        loginPage.navigateTo(string, string2);
    }

}
