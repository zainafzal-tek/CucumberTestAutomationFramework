package com.vytrack.pages;

import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCalenderEventPage extends BasePage {

    @FindBy(xpath = "//div/a[@class = 'btn main-group btn-primary pull-right ']")
    private WebElement createCalenderEventBtn;

    @FindBy(xpath = "(//div/input)[5]")
    private WebElement titleInputBox;

    @FindBy(xpath = "(//iframe)[1]")
    private WebElement descriptionIframe;

    @FindBy(id = "tinymce")
    private WebElement descriptionInputBox;

    public void clickOnCreateCalenderEventBtn(){
        createCalenderEventBtn.click();
    }

    public void enterTitle(String value){
        BrowserUtils.enterText(titleInputBox, value);
    }

    public void enterDescription(String value){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        //switch to default content just to be sure we are not in any frame:
        Driver.getDriver().switchTo().defaultContent();

        //wait for frame and switch to it:    (wait method available to wait and switch and switch at the same time)
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionIframe));

        //enter the text:
        descriptionInputBox.sendKeys(value);

        //Exit the frame
        Driver.getDriver().switchTo().defaultContent();
    }

    public String getDataFromGeneralInfo(String parameterName){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        String xpath = "//label[text() = '" + parameterName + "']/../div/div";

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return element.getText().trim();

    }

}
