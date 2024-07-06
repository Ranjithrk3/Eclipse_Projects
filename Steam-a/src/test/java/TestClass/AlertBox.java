package TestClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import PageObjects.AlertboxPOM;

public class AlertBox {

	public AlertboxPOM alert;
	public WebDriver driver;
	public WebDriverWait wait;
	public ExtentReports extent;
	public ExtentTest test;

	public AlertBox(WebDriver driver, ExtentReports extent) {
		this.driver = driver;
		this.extent = extent;
		wait=new WebDriverWait(driver,Duration.ofSeconds(30000));
		alert= new AlertboxPOM(driver);
	}

	public void AlertboxFunction() {
		
	
			driver.get("https://demoqa.com/alerts");
			
		
			
		

	}

}
