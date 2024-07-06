package TestClass;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentSparkReporter htmlreporter;
	public ExtentTest test;
	// Excel with Registratin
	// Dropdown
	// AlertBox
	// different Xpath

	@BeforeClass
	public void Setup() {

		extent = new ExtentReports();
		LocalDateTime ld = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
		String FormattedDateTime = ld.format(formatter);
		String ReportFilename = "Report" + FormattedDateTime + ".html";

		htmlreporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\ExtentReports\\" + ReportFilename);
		extent.attachReporter(htmlreporter);

		driver = new ChromeDriver();

		driver.manage().window().maximize();

	}

	@AfterClass
	public void Teardown() {
		extent.flush();
		driver.close();

	}

}
