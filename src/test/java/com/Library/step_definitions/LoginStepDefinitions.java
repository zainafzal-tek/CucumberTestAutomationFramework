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

    LibraryLoginPage libraryLoginPage;

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
        Driver.closeDriver();

    }

    @Given("Librarian is on landing page")
    public void librarian_is_on_landing_page() {

        String url = ConfigurationReader.getProperty("libraryUrl");
        Driver.getDriver().get(url);

    }

    @When("Librarian logs in")
    public void librarian_logs_in() {

        String librarianEmail = ConfigurationReader.getProperty("librarianEmail");
        String librarianPassword = ConfigurationReader.getProperty("librarianPassword");

        //Re-instancing login page object to avoid any conflicts:
        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();

        libraryLoginPage.login(librarianEmail, librarianPassword);

    }

    @Then("Librarian should see User, Books and Borrowed books")
    public void librarian_should_see_user_books_and_borrowed_books() {

        WebElement usersHeader = Driver.getDriver().findElement(By.id("user_count"));
        WebElement booksHeader = Driver.getDriver().findElement(By.id("book_count"));
        WebElement borrowedBooks = Driver.getDriver().findElement(By.id("borrowed_books"));

        //asserting to verify if these headers are available:
        Assert.assertTrue("Users header is not displayed", usersHeader.isDisplayed());
        Assert.assertTrue("Book header is not displayed!", booksHeader.isDisplayed());
        Assert.assertTrue("Borrowed books header is not displayed", borrowedBooks.isDisplayed());

        Driver.closeDriver();

    }


}
