package Selenium.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.Forgotpassword;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import resources.Driver;

public class HomePage extends Driver {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Driver.class.getName());
	
	@BeforeTest
	public void initialization() throws IOException {
		driver = InitializeDriver();
		log.info("driver is initialised");
		
	}
	

	@Test(dataProvider="getData")
	
	public void InitializeHomepage(String userName, String password,String text) throws IOException {
		
		
		driver.get(prop.getProperty("url"));
		
		LandingPage l= new LandingPage(driver);
	    LoginPage lp =l.login();
		
		lp.email().sendKeys("userName");
		lp.password().sendKeys("password");
		System.out.println(text);
		
		lp.Login().click();
	Forgotpassword fp=	lp.forgotPasswrd();
	fp.email().sendKeys("wer56");
	fp.sendmeInstructions().click();
		
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[2][3]; //0,1 ie 2 types of test cases in row and 0,1,2 ie 3 values in column for the test
		
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="Restricted User";
				

		data[1][0]="restricteduser@qw.com";
		data[1][1]="456788";
		data[1][2]="Non-Restricted User";
		
		return data;
		
	}
	

	
}
