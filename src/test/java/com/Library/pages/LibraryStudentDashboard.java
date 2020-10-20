package com.Library.pages;

import com.Library.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryStudentDashboard {

    public LibraryStudentDashboard() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class = 'nav-link'])[1]")
    public WebElement booksLink;

    @FindBy(xpath = "(//a[@class = 'nav-link'])[2]")
    public WebElement borrowingBooksLink;

    @FindBy(id = "book_categories")
    public WebElement bookCategoriesDropDown;

    @FindBy(className = "form-control input-sm input-xsmall input-inline")
    public WebElement showRecordsDropdown;

    @FindBy(className = "form-control input-sm input-small input-inline")
    public WebElement searchBox;

    @FindBy(id = "tbl_books")
    public WebElement tableOfBooks;



}
