package com.Library.step_definitions;

import com.Library.pages.LibraryLoginPage;
import com.Library.pages.LibraryStudentDashboard;
import com.Library.utils.ConfigurationReader;
import com.Library.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookCategoriesStepDefinitions {

    LibraryLoginPage libraryLoginPage;
    static LibraryStudentDashboard libraryStudentDashboard;
    static WebDriverWait wait;

    static {
        wait = new WebDriverWait(Driver.getDriver(), 10);
    }

    @Given("Student is on dashboard")
    public void student_is_on_dashboard() {

        String url = ConfigurationReader.getProperty("libraryUrl");
        Driver.getDriver().get(url);

        String email = ConfigurationReader.getProperty("studentLoginEmail");
        String password = ConfigurationReader.getProperty("studentPassword");

        //instancing login page:
        libraryLoginPage = new LibraryLoginPage();

        //logging in:
        libraryLoginPage.login(email, password);

        //asserting student is on dashboard:
        WebElement bookManagementHeader = Driver.getDriver().findElement(By.xpath("//div/h3[.='Book Management']"));

        wait.until(ExpectedConditions.visibilityOf(bookManagementHeader));

        Assert.assertTrue("Student is not on dashboard", bookManagementHeader.isDisplayed());

    }

    @When("Student clicks on book categories drop-down")
    public void student_clicks_on_book_categories_drop_down() {

        //initializing library student dashboard object:
        libraryStudentDashboard = new LibraryStudentDashboard();

        //clicking on dropdown:
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(libraryStudentDashboard.bookCategoriesDropDown).click().perform();

    }

    @Then("Student should see all categories of books available")
    public void student_should_see_all_categories_of_books_available() {

        Select select = new Select(libraryStudentDashboard.bookCategoriesDropDown);

        //clicking on one option to see if dropdown is showing options:
        select.selectByVisibleText("Action and Adventure");

        WebElement actionsAndAdventure = Driver.getDriver().findElement(By.xpath("(//td[.='Action and Adventure'])[1]"));
        Assert.assertTrue("Actions and advent",actionsAndAdventure.isDisplayed());

        Driver.closeDriver();

    }


}
