package com.orangehrm.steps;

import com.orangehrm.utils.BaseClass;
import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.DbUtils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	//execute always first, here we are setting up browser (and reading property file in base class)
	@Before
	public void start(Scenario scenario) {
		System.out.println("Starting test: "+scenario.getName());
		BaseClass.setUp();		
	}
	
	@After
	public void end(Scenario scenario) {
		System.out.println("Ending test: "+scenario.getName());
		
		if(scenario.isFailed()) {
			//taking screenshot
			byte[] shot=CommonMethods.takeScreenshot();
			//attaching to the report
			scenario.embed(shot, "image/png");		
		}
		
		BaseClass.tearDown();		
	}
	
	//this execute second
	@Before("@db")
	public void open() {
		DbUtils.createConnection();
	}
	
	@After("@db")
	public void close() {
		DbUtils.closeConnection();
	}
	
}
