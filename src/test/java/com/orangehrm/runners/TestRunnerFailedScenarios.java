package com.orangehrm.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features ="@target/return.txt" 
               , glue = { "com/orangehrm/steps" }
               , plugin = { "pretty",
		                    "html:target/cucumber-default-reports", 
		                    "json:target/cucumber.json",
		                    "rerun:target/rerun.txt" }
               , tags = { "@temp" }
             , dryRun = false
               , monochrome = true )

public class TestRunnerFailedScenarios {

}
