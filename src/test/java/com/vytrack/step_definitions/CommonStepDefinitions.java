package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonStepDefinitions {

    //created login page to gain access to base page method 'navigateTo'
    LoginPage loginPage = new LoginPage();
    //used polymorphism to refer base page while creating login page object to gain base page methods
    //NOTE!: This step is not necessary but recommended because it is good practice and instead of calling sub class
    //       we get direct access to base page through polymorphism even though
    //       login page is gaining all non private methods and variables since it is extending base page
    BasePage basePage = new LoginPage();

    // here {string} will represent tabName and {string2} will represent moduleName
    //module name is also links under tab
    @Given("user navigates to {string} and {string}")
    public void user_navigates_to_and(String string, String string2) {
        loginPage.navigateTo(string, string2);
    }

    @When("user clicks save and close button")
    public void user_clicks_save_and_close_button() {
        System.out.println("Clicking save and close");
        basePage.clickSaveAndClose();
    }
}
