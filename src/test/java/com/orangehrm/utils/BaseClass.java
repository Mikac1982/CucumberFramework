package com.orangehrm.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {

public static WebDriver driver;
	
	public static void setUp() {
		//bringing our property file to set up browser 
		ConfigsReader.readProperties(Constants.CREDENTIALS_FILEPATH);
		String browser=ConfigsReader.getProperty("browser");
		
		if (browser.equalsIgnoreCase("chrome")) {
			
		    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");	
		    driver=new ChromeDriver();
		    
		}else if (browser.equalsIgnoreCase("firefox")) {
		    System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
		    driver=new FirefoxDriver();
		    
		}else if(browser.equals("ie")) {
			 System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer");
			 driver=new InternetExplorerDriver();
			
		}else {
			System.out.println("Browser given is wrong");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//bringing our property file to set up url
		driver.get(ConfigsReader.getProperty("url"));
	}
	
	public static void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
}
