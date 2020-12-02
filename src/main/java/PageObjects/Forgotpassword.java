package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Forgotpassword {
	
	public WebDriver driver;
	
	public Forgotpassword(WebDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	By email=By.cssSelector("#user_email");
	By sendmeInstructions = By.cssSelector("[type='submit']");
	

	
	public WebElement email() {
		return driver.findElement(email);
	}
	
	public WebElement sendmeInstructions() {
		return driver.findElement(sendmeInstructions);
	}
	

}
