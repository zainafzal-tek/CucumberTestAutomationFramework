package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources",
        glue = "com\\vytrack\\step_definitions",
        dryRun = false,

        //This is used to determine which testa we cucumber would only run
        tags = "@parametrized_test"
)
public class CucumberRunner {
}
