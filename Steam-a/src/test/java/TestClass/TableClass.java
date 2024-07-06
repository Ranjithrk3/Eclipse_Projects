package TestClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageObjects.TablePOM;

public class TableClass {
	public WebDriver driver;
	public TablePOM tble;
	public ExtentReports extent;
	public ExtentTest test;
	public WebDriverWait wait;

	public TableClass(WebDriver driver, ExtentReports extent) {
		this.driver = driver;
		this.extent = extent;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30000));
		tble = new TablePOM(driver);

	}

	public void TableFunction() throws IOException {
		test = extent.createTest("Table And its Functions");
		driver.get("https://the-internet.herokuapp.com/tables");
		test.log(Status.INFO, "Driver has Launched Successfully");
		wait.until(ExpectedConditions.visibilityOf(tble.Example1));
		test.log(Status.INFO, "Table is Diplayed");
		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		test.log(Status.INFO, "Table Contents identified as WebElements");
		try {
			UpperLoop: for (int i = 1; i < rows.size(); i++) {
				WebElement Row = rows.get(i);
				test.log(Status.INFO, "Row " + i + " Identified");

				List<WebElement> columns = Row.findElements(By.tagName("td"));
				test.log(Status.INFO, "Columns of the Row " + i + " is Identified");
				for (WebElement cell : columns) {
					test.log(Status.INFO, "Verifying the Cell Values");
					String CellValue = cell.getText();
					System.out.println(CellValue);
					if (CellValue.equals("jsmith@gmail.com")) {
						test.log(Status.INFO, "Cell Value is identified as " + CellValue);
						File TableRow = cell.getScreenshotAs(OutputType.FILE);
						FileUtils.copyFile(TableRow,
								new File(System.getProperty("user.dir") + "\\Screenshots\\TablePassed.png"));

						test.log(Status.PASS, "Cell value of the Table as identified as Expected one")
								.addScreenCaptureFromPath(
										System.getProperty("user.dir") + "\\Screenshots\\TablePassed.png");
						Assert.assertTrue(true);
						break UpperLoop;
					}
				}
			}

		} catch (Exception e) {
			File Table = tble.Example1.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Table, new File(System.getProperty("user.dir") + "\\Screenshots\\TableFailed.png"));
			test.log(Status.FAIL, "Cell value of the Table is not identified as Expected one");
			Assert.assertTrue(false);
		}
	}

}
