package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	By email=By.cssSelector("#user_email");
	By password = By.cssSelector("#user_password");
	By login = By.cssSelector("input[type=submit]");
	By forgotpswd = By.cssSelector("[href*='password/new']");
	
	public Forgotpassword forgotPasswrd() {
		driver.findElement(forgotpswd).click();
		return new Forgotpassword(driver);
		//Forgotpassword fp = new Forgotpassword(driver);
		//return fp;
	}
	
	public WebElement email() {
		return driver.findElement(email);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement Login() {
		return driver.findElement(login);
	}

}
