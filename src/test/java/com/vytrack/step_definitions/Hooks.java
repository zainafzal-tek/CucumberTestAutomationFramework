package com.vytrack.step_definitions;

import com.vytrack.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

/**
 * Hooks name is not reserved, You may name this class in any way
 * For example: SuiteSetupAndTearDown
 * Hooks triggered based on tags, not on class name, or their location.
 * These methods can be a part of any step definition class.
 * Common practice is to store then in the separate class.
 */

public class Hooks {

    //hook after is == @AfterMethod in TestNG
    //hook before == @BeforeMethod in TestNG
    //Its not a good idea to mix implicit and explicit waits: it can lead to unexpectedly long waits.
    //usually we just use explicit and fluent waits

    //This will before and after every DB tag step
    @Before("@db")
    public void dbSetup(){
        System.out.println("Connecting to the Database");
    }

    @After("@db")
    public void dbTearDown(){
        System.out.println("Disconnecting from the database");
    }

    @Before
    public void setup(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
        System.out.println(":::Starting Automation:::");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario){
        //this is a hook after
        //runs automatically after every test
        if (scenario.isFailed()){
            byte[] data = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", scenario.getName());
        }
        Driver.closeDriver();
        System.out.println(":::End of test execution:::");
    }

}
