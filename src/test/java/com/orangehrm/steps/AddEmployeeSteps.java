package com.orangehrm.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.orangehrm.pages.AddEmployeePage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddEmployeeSteps extends CommonMethods {

	LoginPage login;
	HomePage home;
	AddEmployeePage emp;

	@Given("I logged in into OrangeHrm")
	public void i_logged_in_into_OrangeHrm() {
		login = new LoginPage();
		home = new HomePage();
		emp = new AddEmployeePage();
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@When("I click on PIM link")
	public void i_click_on_PIM_link() {
		click(home.PIM);
	}

	@When("I click on AddEmployee link")
	public void i_click_on_AddEmployee_link() {
		click(home.addEmployee);
	}

	@When("I provide {string}, {string}, {string} and {string}")
	public void i_provide_and(String fName, String mName, String lName, String location) {
		sendText(emp.firstName, fName);
		sendText(emp.middleName, mName);
		sendText(emp.lastName, lName);
		click(emp.location);
		selectList(emp.locationList, location);
	}

	@When("I click on save button")
	public void i_click_on_save_button() {
		click(emp.saveBtn);
	}

	@Then("I see {string}, {string} is displayed")
	public void i_see_is_displayed(String fName, String lName) {
	//	waitForElementBeClickable(emp.empCheck, 20);
		String empName = emp.empCheck.getText();
		Assert.assertEquals(fName +" "+lName, empName);
	}
	
	@Then("I see following labels")
	//variable addEmpLabels holds all the values of data table from feature file
	public void i_see_following_labels(DataTable addEmpLabels) {
	    
		//printing all the expected labels we have
		System.out.println("----Printing labels from cucumber data table----");
		List<String> labels = addEmpLabels.asList();
		
		for (String label:labels) {
			System.out.println(label);	
		}
		
		//printing all actual values we have in the application
		System.out.println("----Printing label text from the application----");
		List<WebElement> labelList = emp.addEmpLabels;
		for (WebElement label:labelList) {
			String labeltxt=label.getText();
			System.out.println(labeltxt.replace("*", ""));
		}
	}
	
	
	
}
