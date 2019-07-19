package com.orangehrm.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features"
		,glue="com/orangehrm/steps"
		,monochrome=true
	//   ,dryRun=true
	    ,tags= {"@temp"}
		,plugin= {"pretty"
				, "html:target/cucumber-default-reports"
				, "json:target/cucumber.json"}
		//      , "return:target/retrun.txt" -->to run failed scenarios; this file is in the target folder
		)

public class TestRunner {

}
