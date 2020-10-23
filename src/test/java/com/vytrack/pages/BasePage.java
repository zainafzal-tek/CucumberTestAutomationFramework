package com.vytrack.pages;

import com.vytrack.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    //Purpose of BasePage class is to store common elements <For interview purposes>
    //another way is to create Common page element class and store all common elements there

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "oro-subtitle")
    protected WebElement pageSubTitle;

    public String getPageSubTitleText() {
        return pageSubTitle.getText();
    }

    /**
     * Method for navigation in vtrack app
     * @param tabName, for example: Dashboard, Sales, Activities..
     * @param moduleName, one of the values that will be visible after clicking on the tab (AKA links under tab).
     *                For fleet, these are the modules: Vehicles, Vehicle Odometer, Vehicle Costs, etc..
     */

    public void navigateTo(String tabName, String moduleName){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);

        String tabXpath = "//*[contains(text(), '"+ tabName +"') and @class = 'title title-level-1']";
        String moduleXpath = "\"//*[contains(text(), '"+ moduleName +"') and @class = 'title title-level-2']";

        //wait for presence of element for it to be clickable and then once able to click, click on it:
        WebElement tabElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tabXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(tabElement)).click();

        WebElement moduleElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moduleXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(moduleElement)).click();
    }

}
