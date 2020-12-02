package Selenium.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import PageObjects.LandingPage;
import resources.Driver;

public class ValidateNavigationBar extends Driver {

	public WebDriver driver;
	@BeforeTest
	public void initialization() throws IOException {
		driver = InitializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	
	
	@Test
	
	public void InitializeHomepage() throws IOException {
		
		
		LandingPage l= new LandingPage(driver);
		((WebElement) l.login()).click();
		Assert.assertTrue(l.NavigationBar().isDisplayed());
		
		
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
	
	
	}

