package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;

public class AddEmployeePage extends BaseClass {

	@FindBy(id = "firstName")
	public WebElement firstName;

	@FindBy(id = "middleName")
	public WebElement middleName;

	@FindBy(id = "lastName")
	public WebElement lastName;

	@FindBy(id="employeeId")
    public WebElement id;
	
	@FindBy(xpath = "//div[@id='location_inputfileddiv']//input")
	public WebElement location;

	@FindBy(xpath = "//div[@id='location_inputfileddiv']//ul")
	public WebElement locationList;

	@FindBy(id = "systemUserSaveBtn")
	public WebElement saveBtn;

    @FindBy(id="pim.navbar.employeeName")
	public WebElement empCheck;;
	
	@FindBy(xpath="//form[@id='pimAddEmployeeForm']//label")
	public List<WebElement> addEmpLabels;
	
	@FindBy(xpath="//label[text()='Create Login Details']")
	public WebElement createLogDet;
	
	@FindBy(id="username")
	public WebElement userName;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="confirmPassword")
	public WebElement confPassword;
	
	@FindBy(xpath="//div[@id='essRoleId_inputfileddiv']//input")
	public WebElement essRole;
	
	@FindBy(xpath="//div[@id='essRoleId_inputfileddiv']//ul")
	public WebElement essRoleList;
	
	@FindBy(xpath="//div[@id='supervisorRoleId_inputfileddiv']//input")
	public WebElement defSup;
	
	@FindBy(xpath="//div[@id='supervisorRoleId_inputfileddiv']//ul")
	public WebElement defSupList;
	

	
	public AddEmployeePage() {
		PageFactory.initElements(driver, this);
	}
}
