package TestClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

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
		wait = new WebDriverWait(driver, Duration.ofSeconds(30000));
		alert = new AlertboxPOM(driver);
	}

	public void AlertboxFunction() throws IOException {

		try {
		test = extent.createTest("Alert Box Testing");
		driver.get("https://demoqa.com/alerts");
		test.log(Status.INFO, "Driver has Launched Successfully");
		Actions a = new Actions(driver);

		// SimpleAlert
		wait.until(ExpectedConditions.visibilityOf(alert.SimpleAlert));
		test.log(Status.INFO, "Simple Alert Displayed");
		alert.SimpleAlert.click();
		test.log(Status.INFO, "Simple Alert Clicked");
		driver.switchTo().alert().dismiss(); // Dismissed the ALert
		test.log(Status.INFO, "Simple Alert Dismissed");

		// Time Delayed Alert
		wait.until(ExpectedConditions.visibilityOf(alert.TimeDelayedAlert));
		test.log(Status.INFO, "TimeDelayed Alert Displayed");
		alert.TimeDelayedAlert.click();
		test.log(Status.INFO, "TimeDelayed Alert Clicked");
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept(); // Accepted the Alert
		test.log(Status.INFO, "TimeDelayed Alert Accepted");

		// Confirmation ALert
		wait.until(ExpectedConditions.visibilityOf(alert.ConfirmationAlert));
		test.log(Status.INFO, "Confirmation Alert Displayed");
		alert.ConfirmationAlert.click();
		test.log(Status.INFO, "Confirmation Alert Clicked");
		String confirmationAlertTxt = driver.switchTo().alert().getText();
		System.out.println(confirmationAlertTxt);
		driver.switchTo().alert().dismiss(); // Dismissed the ALert
		test.log(Status.INFO, "Confirmation Alert Dismissed");

		// PromptAlert
		wait.until(ExpectedConditions.visibilityOf(alert.PromptAlert));
		test.log(Status.INFO, "Prompt Alert Displayed");
		alert.PromptAlert.click();
		test.log(Status.INFO, "Prompt Alert Clicked");
		driver.switchTo().alert().sendKeys("This is Prompt alert Text");
		test.log(Status.INFO, "TestData sent to the Prompt alert");
		driver.switchTo().alert().accept(); // Accepted the Alert
		test.log(Status.INFO, "Prompt Alert Accepted");
		File AlertPassed= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(AlertPassed, new File(System.getProperty("user.dir")+"\\Screenshots\\AlertPassed.png"));
		test.log(Status.PASS, "ALert TestCase Passed").addScreenCaptureFromPath(System.getProperty("user.dir")+"\\Screenshots\\AlertPassed.png");
		
		
		
		}
		catch (Exception e) {
			File AlertFailed= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(AlertFailed, new File(System.getProperty("user.dir")+"\\Screenshots\\AlertFailed.png"));
			test.log(Status.PASS, "ALert TestCase Passed"+e).addScreenCaptureFromPath(System.getProperty("user.dir")+"\\Screenshots\\AlertFaied.png");
			
		}

	}

}
