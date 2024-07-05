package TestClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentSparkReporter htmlreporter;
	public static ExtentTest test ;
	
	
@BeforeClass
public void Setup()
{
	extent = new ExtentReports();
	htmlreporter= new ExtentSparkReporter(System.getProperty("user.dir")+"\\ExtentReports\\Report.html");
	extent.attachReporter(htmlreporter);
	
	driver= new ChromeDriver();
	
}
	
@AfterClass
public void Teardown()
{
	extent.flush();
	driver.close();
	
}
	

	
	
	
	
	
	
	
	
	

}
