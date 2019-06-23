package com.orangehrm.steps;

import org.junit.Assert;

import com.orangehrm.pages.AddLocationPage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.utils.CommonMethods;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AddLocationsSteps extends CommonMethods{

	HomePage home=new HomePage();		
	AddLocationPage addLoc=new AddLocationPage();
	
	@When("I click on Admin link")
	public void i_click_on_Admin_link() {
	    click(home.admin);
	}

	@When("I click on Organization link")
	public void i_click_on_Organization_link() {
	   click(home.organization);
	}

	@When("I click on Locations link")
	public void i_click_on_Locations_link() {
	    click(home.locations);
	}

	@When("I click on add button")
	public void i_click_on_add_button() {
	    click(addLoc.add);
	}

	@When("I provide location details {string} and {string} and {string} and {string}")
	public void i_provide_location_details_and_and_and(String name, String country, String city, String zip) {
	    sendText(addLoc.name, name);
	    click(addLoc.countryDD);
		selectList(addLoc.countryList, country);
		sendText(addLoc.city, city);
		sendText(addLoc.zip, zip);
	}

	@When("I click on save button two")
	public void i_click_on_save_button_two() {
	    click(addLoc.locSaveBtn);
	}
	
	@Then("I see location  {string} is successfully added")
	public void i_see_location_is_is_successfully_added(String country) {
		Assert.assertTrue(home.verifyLoc.isDisplayed());
	}

}
