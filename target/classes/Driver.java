package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver InitializeDriver() throws IOException {

	prop = new Properties();
	FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\DriverData.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Desktop\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		 driver = new ChromeDriver();
	}
	
	else if(browserName.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Desktop\\selenium\\geckodriver-v0.21.0-win32\\geckodriver.exe");
		 driver = new FirefoxDriver();
	}
	
	else if(browserName.equals( "IE")) {
		System.setProperty("webdriver.ie.driver", "C:\\Users\\User\\Desktop\\selenium\\IEDriverServer_x64_2.39.0 (1)\\IEDriverServer.exe");
		 driver = new InternetExplorerDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	return driver;
}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException {
		
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source, new File(destination));
	return destination;
	
	}
}