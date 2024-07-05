package TestClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageObjects.ExcelWIthRegistrationPOM;

public class ExcelWithRegistration extends BaseClass {
	public ExcelWIthRegistrationPOM excel;
	public WebDriverWait wait;


	
	
	
	
	
	public ExcelWithRegistration() {
		
		excel=new ExcelWIthRegistrationPOM(driver);
		wait=new WebDriverWait(driver,Duration.ofSeconds(30000));
		
	}
	
	public void ExcelFunction() throws IOException
	{
		test=extent.createTest("Excel And its Functions");
		
		driver.get("https://petstore.octoperf.com/actions/Account.action?newAccountForm=");
		test.log(Status.INFO,"Driver Navigated to the URL");
		wait.until(ExpectedConditions.visibilityOf(excel.UserID));
		String Path=System.getProperty("user.dir")+"\\Excel\\ExcelFunction.xlsx";
		test.log(Status.INFO,"Path of the Excel file navigated");
		FileInputStream fis = new FileInputStream(Path);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		int RowCount=sheet.getPhysicalNumberOfRows();
		int ColumnCount = sheet.getRow(1).getPhysicalNumberOfCells();
		test.log(Status.INFO,"RowCount and Column count identified");
		
		for(int i=1;i<RowCount;i++)
		{
			for(int j=0;j<ColumnCount;)
			{
				test.log(Status.INFO,"Registration form content will be automated");
				excel.UserID.clear();
				excel.UserID.sendKeys(sheet.getRow(i).getCell(j).toString());
				excel.NewPassword.clear();
				excel.NewPassword.sendKeys(sheet.getRow(i).getCell(j+1).toString());
				excel.RepeatPassword.clear();
				excel.RepeatPassword.sendKeys(sheet.getRow(i).getCell(j+2).toString());
				excel.Firstname.clear();
				excel.Firstname.sendKeys(sheet.getRow(i).getCell(j+3).toString());
				excel.Lastname.clear();
				excel.Lastname.sendKeys(sheet.getRow(i).getCell(j+4).toString());
				excel.Email.clear();
				excel.Email.sendKeys(sheet.getRow(i).getCell(j+5).toString());
				excel.Phone.clear();
				excel.Phone.sendKeys(sheet.getRow(i).getCell(j+6).toString());
				excel.Address1.clear();
				excel.Address1.sendKeys(sheet.getRow(i).getCell(j+7).toString());
				excel.Address2.clear();
				excel.Address2.sendKeys(sheet.getRow(i).getCell(j+8).toString());
				excel.City.clear();
				excel.City.sendKeys(sheet.getRow(i).getCell(j+9).toString());
				excel.State.clear();
				excel.State.sendKeys(sheet.getRow(i).getCell(j+10).toString());
				excel.Zip.clear();
				excel.Zip.sendKeys(sheet.getRow(i).getCell(j+11).toString());
				excel.Country.clear();
				excel.Country.sendKeys(sheet.getRow(i).getCell(j+12).toString());
				test.log(Status.INFO,"All input fields got Datas");
				excel.SaveInfo.click();
				test.log(Status.INFO,"Save my information button clicked");
				if(driver.getPageSource().contains("HTTP Status 500 – Internal Server Error")) {
				
					File Fn= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(Fn, new File(System.getProperty("user.dir")+"\\Screenshots\\ExcelFailed.png"));
					String ReportScreenshot=Fn.toString();
					test.log(Status.FAIL,"Method is Failed").addScreenCaptureFromPath(System.getProperty("user.dir")+"\\Screenshots\\ExcelFailed.png");
					Assert.assertTrue(false);
				}else {
				wait.until(ExpectedConditions.visibilityOf(excel.SignIn));
				excel.SignIn.click();
				wait.until(ExpectedConditions.visibilityOf(excel.RegisterNow));
				excel.RegisterNow.click();
				test.log(Status.PASS,"Method is Passed");
				File Fn= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(Fn, new File(System.getProperty("user.dir")+"\\Screenshots\\ExcelPassed.png"));
				Assert.assertTrue(true);
				}
				
				
			}
		}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	

}
