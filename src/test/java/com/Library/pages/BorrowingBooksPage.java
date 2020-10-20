package com.Library.pages;

import com.Library.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BorrowingBooksPage {

    public BorrowingBooksPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user_list")
    public WebElement userDropDown;

    @FindBy(id = "borrowed_list")
    public WebElement borrowedBooksTable;

}
