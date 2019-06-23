package com.orangehrm.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features"
		,glue="com/orangehrm/steps"
		,monochrome=true
	    ,dryRun=true
	    ,tags= {"@createLD"}
		,plugin= {"pretty", "html:target/cucumber-default-reports"}
		)

public class TestRunnerOrangeHRM {

}
