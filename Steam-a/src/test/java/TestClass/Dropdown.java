package TestClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageObjects.DropdownPOM;

public class Dropdown {
	public DropdownPOM dd;
	public WebDriver driver;
	public WebDriverWait wait;
	public ExtentReports extent;
	public ExtentTest test;


	public Dropdown(WebDriver driver,ExtentReports extent) {
		this.driver = driver;
		this.extent=extent;
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(30000));
		dd = new DropdownPOM(driver);
	}

public void DropdownFunction() throws IOException {

	test= extent.createTest("Dropdown and its Functionalities");
	try {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	driver.get("https://formstone.it/components/dropdown/demo/");
	test.log(Status.INFO, "Driver navigated to the Dropdown page");
	Select basic= new Select(dd.Basic);
	basic.selectByIndex(1);
	test.log(Status.INFO, "Basic Dropdown selelcted as Index 1");
	js.executeScript("arguments[0].scrollIntoView(true);", dd.group);
	test.log(Status.INFO, "Scroll into the Groups Dropdown");
	Select group= new Select(dd.group);
	group.selectByValue("6");
	test.log(Status.INFO, "Group Dropdown selelcted as Value 6");
	js.executeScript("arguments[0].scrollIntoView(true);", dd.Native);
	test.log(Status.INFO, "Scroll into the Native Dropdown");
	Select nativ= new Select(dd.Native);
	nativ.selectByVisibleText("Three");
	test.log(Status.INFO, "Native Dropdown selelcted as VisibleText 'Three'");
	test.log(Status.PASS, "Dropdown Test Passed");
	Assert.assertTrue(true);
	
	}
	catch (Exception e) {
		
		test.log(Status.FAIL, "Dropdown Test Failed");
		File DropdownFail= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(DropdownFail, new File(System.getProperty("user.dir")+"\\Screenshots\\DropdownFailed.png"));
		Assert.assertTrue(false);
	}
	
	
	
	
	
	
	
}

}
