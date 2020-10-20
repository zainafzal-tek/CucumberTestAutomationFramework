package com.Library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //path from content root:
        features = "src\\test\\resources\\features\\Library.login.feature",

        //path from source root:
        glue = "com\\Library\\step_definitions",

        dryRun = false
)


public class LoginRunner {
}
