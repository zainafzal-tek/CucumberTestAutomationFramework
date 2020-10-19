package com.vytrack.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinitions {

    WebDriver driver;

    //This is Sales manager login:
    @Given("user is on the landing page")
    public void user_is_on_the_landing_page(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://qa1.vytrack.com");
    }

    @When("user logs in")
    public void user_logs_in() throws InterruptedException {
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager110");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);
        Thread.sleep(1500);
    }

    @Then("user should see dashboard page")
    public void user_should_see_dashboard_page() {
       String expected = "Dashboard";
       String actual = driver.findElement(By.className("oro-subtitle")).getText().trim();
       Assert.assertEquals("Title is not correct!", expected, actual);
       driver.quit();
    }

    //Self practice. This is for the driver dashboard:
    @Given("driver is on the landing page")
    public void driver_is_on_the_landing_page() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://qa2.vytrack.com");
    }

    @When("driver logs in")
    public void driver_logs_in() throws InterruptedException {
        driver.findElement(By.id("prependedInput")).sendKeys("user170");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);
        Thread.sleep(1500);
    }

    @Then("driver should see dashboard")
    public void driver_should_see_dashboard() {
        String expected = "Fleet Management";
        String actual = driver.findElement(By.linkText("Fleet Management")).getText().trim();
        Assert.assertEquals("Driver is not on dashboard", expected, actual);
        driver.quit();
    }

}
