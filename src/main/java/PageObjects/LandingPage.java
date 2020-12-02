package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	By signin=By.cssSelector("a[href*=sign_in]");
	By title = By.cssSelector(".text-center > h2");
	By Navbar = By.cssSelector("div.navbar.navbar-default.navbar-static-top div.container");
	
	public LoginPage login() {
		 driver.findElement(signin).click();
		 LoginPage lp= new LoginPage(driver);
		 return lp;
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement NavigationBar() {
		return driver.findElement(Navbar);
	}

	

}
