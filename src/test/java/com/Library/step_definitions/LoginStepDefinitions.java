package com.Library.step_definitions;

import com.Library.pages.LibraryLoginPage;
import com.Library.utils.ConfigurationReader;
import com.Library.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginStepDefinitions {

    @Given("Student is on library landing page")
    public void student_is_on_library_landing_page() {

        String url = ConfigurationReader.getProperty("libraryUrl");
        Driver.getDriver().get(url);

    }

    @When("Student logs in")
    public void student_logs_in() {

        String email = ConfigurationReader.getProperty("studentLoginEmail");
        String password = ConfigurationReader.getProperty("studentPassword");

        //Getting login page object:
        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();

        libraryLoginPage.login(email, password);

    }

    @Then("Student should see the books table")
    public void student_should_see_the_books_table() {

        WebElement table = Driver.getDriver().findElement(By.id("tbl_books"));

        //asserting table is visible:
        Assert.assertTrue(table.isDisplayed());

    }


}
