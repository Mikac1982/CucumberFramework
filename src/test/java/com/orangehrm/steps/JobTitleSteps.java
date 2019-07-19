package com.orangehrm.steps;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import com.orangehrm.pages.JobTitlePage;
import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.DbUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JobTitleSteps extends CommonMethods {

	JobTitlePage jt;
	List<Map<String, String>> uiResults; //making list variables global
	List<Map<String, String>> dbResults;
	
	public JobTitleSteps() {
		jt=new JobTitlePage();
	}

	@Given("I click on Job link")
	public void i_click_on_Job_link() {
		click(jt.job);
	}

	@When("I click on Job Titles")
	public void i_click_on_Job_Titles() {	
		click(jt.jobTitles);
	}

	@When("I get all Job Titles from UI")
	public void i_get_all_Job_Titles_from_UI() {

		uiResults=new ArrayList<>();
		
		System.out.println("---------Printing results from UI-----------");
		
		for (WebElement row : jt.jobTitleTableRows) {
			Map<String, String> uiDataMap=new LinkedHashMap<>();
			
			String rowText = row.getText().replace(" ohrm_edit", "");;
		//	rowText.replace("ohrm_edit", "").trim();
			
			uiDataMap.put("JOB_TITLE", rowText);
		//	System.out.println(uiDataMap);
			
			uiResults.add(uiDataMap);
		}
		System.out.println(uiResults);
	}

	@When("I execute {string} from Database")
	public void i_execute_from_Database(String sqlQuery) {
        //Executing the query, store results in list of maps
		dbResults = DbUtils.getResultSetData(sqlQuery);
		System.out.println("---------Printing results from DB-----------");
		System.out.println(dbResults);
	}

	@Then("I see results from UI and Database are matched")
	public void i_see_results_from_UI_and_Database_are_matched() {
	
	//	Assert.assertEquals(uiResults, dbResults);
		Assert.assertTrue(uiResults.equals(dbResults));
	}

}
