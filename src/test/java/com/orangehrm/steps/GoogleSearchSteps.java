package com.orangehrm.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.orangehrm.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchSteps extends CommonMethods {

	public static WebDriver driver;

	@Given("I navigated to the Google")
	public void i_navigated_to_the_Google() {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://google.com");
		System.out.println("I am on google page");
	}

	@When("I type search item")
	public void i_type_search_item() {

		driver.findElement(By.cssSelector("input[title='Search']")).sendKeys("music");
		System.out.println("I search for item");
	}

	@When("I click on google search button")
	public void i_click_on_google_search_button() {

	//	WebElement search=driver.findElement(By.xpath("//div[@class='VlcLAe']//center//input[1]"));
		WebElement search=driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[1]"));
		search.click();

		System.out.println("clicked search button");
	}

	@Then("I see search result are displayed")
	public void i_see_search_result_are_displayed() {
		
	
		WebElement results=driver.findElement(By.cssSelector("div#resultStats"));
	    boolean isDisplayed=results.isDisplayed();
	    Assert.assertTrue(isDisplayed);
	    System.out.println("Results are displayed");
	    driver.quit();
	}
   
	
}
