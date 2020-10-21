package com.Library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        //TODO Change path according to System OS
        //path from content root:
        features = "src/test/resources/Library_features",

        //path from source root:
        glue = "com/Library/step_definitions",

        dryRun = false
)


public class CucumberRunner {
}
