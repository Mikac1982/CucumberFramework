package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(css = "li.page-title")
	public WebElement dashboard;

	@FindBy(xpath = "//span[text()='PIM']")
	public WebElement PIM;

	@FindBy(xpath = "//span[text()='Add Employee']")
	public WebElement addEmployee;

	@FindBy(xpath = "//div[@id='menu-content']/ul/li/a/span[2]")
	public WebElement admin;

	@FindBy(xpath = "//span[text()='Organization']")
	public WebElement organization;

	@FindBy(xpath = "//span[text()='Locations']")
	public WebElement locations;

	@FindBy(xpath="//td[@name='listField.name'][3]")
	public WebElement verifyLoc;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

}
