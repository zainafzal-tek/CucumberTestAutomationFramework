package com.Library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\Library.login.feature",
        glue = "com\\Library\\step_definitions",
        dryRun = false
)


public class LoginRunner {
}
