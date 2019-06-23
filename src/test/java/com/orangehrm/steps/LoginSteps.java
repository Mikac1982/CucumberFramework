package com.orangehrm.steps;

import org.junit.Assert;

import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class LoginSteps extends CommonMethods {

	LoginPage login;

	@Given("I see OrangeHrm logo")
	public void i_see_OrangeHrm_logo() {    
		login=new LoginPage();
		boolean isDisplayed=login.logo.isDisplayed();
		Assert.assertTrue(isDisplayed);
	}

	@When("I enter valid username and password")
	public void i_enter_valid_username_and_password() {
		login=new LoginPage();
		sendText(login.userName, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
	}

	@When("I click login button")
	public void i_click_login_button() {
	   click(login.loginBtn);
	}

	@Then("I successfully  logged in")
	public void i_successfully_logged_in() {
	   
		HomePage home=new HomePage();
		Assert.assertTrue(home.dashboard.isDisplayed());
		
	}

	@Then("I close browser")
	public void i_close_browser() {  
       tearDown();
	}

	@When("I enter invalid username and password")
	public void i_enter_invalid_username_and_password() {
	   sendText(login.userName, "Test");
	   sendText(login.password, "test123");
	}
	
	@Then("I see error message is displayed!")
	public void i_see_error_message_is_displayed() {
	    Assert.assertTrue(login.errorMessage.isDisplayed());
	    String errorText=login.errorMessage.getText().trim();
	//  System.out.println(errorText);
	    Assert.assertEquals("Invalid Credentials", errorText);
	}

	@When("I enter invalid username and password I see errorMessage")
	public void i_enter_invalid_username_and_password_I_see_errorMessage(DataTable wrongCredentials) {
	    
		
		
		
		
	}
	
	
	
	
}
