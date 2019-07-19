package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;

public class JobTitlePage extends BaseClass {

	@FindBy(xpath="//span[text()='Job']")
	public WebElement job;

	@FindBy(xpath="//span[text()='Job Titles']")
	public WebElement jobTitles;

	@FindBy(xpath="//table[@class='highlight bordered']/tbody/tr")
	public List<WebElement> jobTitleTableRows;
	
	

	
	public JobTitlePage() {
		PageFactory.initElements(driver, this);
	}

}
