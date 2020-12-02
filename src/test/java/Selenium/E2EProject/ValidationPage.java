package Selenium.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import resources.Driver;

public class ValidationPage extends Driver {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Driver.class.getName());
	
	@BeforeTest
	public void initialization() throws IOException {
		
		driver = InitializeDriver();
		log.info("driver is initialised");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
	}
	

	@Test
	
	public void InitializeHomepage() throws IOException {
		
		driver = InitializeDriver();
		driver.get("http://qaclickacademy.com");
		LandingPage l= new LandingPage(driver);
	     ((WebElement) l.login()).click();
		Assert.assertEquals(l.getTitle().getText(),"Featured Courses");
		log.info("succesfully validated the message ");
		
		
	}
	

	@AfterTest
	public void close() {
		driver.close();
	}
	
	
	}

