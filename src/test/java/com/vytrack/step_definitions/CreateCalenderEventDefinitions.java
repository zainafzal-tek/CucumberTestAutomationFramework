package com.vytrack.step_definitions;

import com.vytrack.pages.CreateCalenderEventPage;
import com.vytrack.utils.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class CreateCalenderEventDefinitions {
    CreateCalenderEventPage calenderEventPage = new CreateCalenderEventPage();

    @Given("user clicks on create calendar event button")
    public void user_clicks_on_create_calendar_event_button() {
        calenderEventPage.clickOnCreateCalenderEventBtn();
    }

    @When("user adds new calendar event information")
    public void user_adds_new_calendar_event_information(Map<String, String> data) {
        data.forEach((key , value) -> System.out.println("Key: " + key + " , Value: " + value));

        System.out.println("Title: " + data.get("Title"));
        System.out.println("Description: " + data.get("Description"));

        //sending keys:
        calenderEventPage.enterTitle(data.get("Title"));
        calenderEventPage.enterDescription(data.get("Description"));

    }

    @Then("user verifies that new calender event is displayed:")
    public void user_verifies_that_new_calender_event_is_displayed(Map<String, String> data){
        //adding wait to see results:
        BrowserUtils.wait(3);

        String title = data.get("Title");
        String description = data.get("Description");

        Assert.assertEquals(title, calenderEventPage.getDataFromGeneralInfo("Title"));
        Assert.assertEquals(description, calenderEventPage.getDataFromGeneralInfo("Description"));
    }

}


