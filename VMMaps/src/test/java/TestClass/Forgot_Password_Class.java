package TestClass;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import POM_Pages.Forgot_Password_POM;
import POM_Pages.Login_POM;

public class Forgot_Password_Class {

 WebDriver driver;
	public Forgot_Password_POM forgot;
	public Login_POM login;
	public WebDriverWait wait;
	
	public Forgot_Password_Class(WebDriver driver) {
		 this.driver=driver;
	 forgot= new Forgot_Password_POM(driver);
		 login = new Login_POM(driver);
		 wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		
		
		
	}
	
	public void Forgot_Password_Valid(WebDriver driver)
	{
		wait.until(ExpectedConditions.visibilityOf(login.Email));
		login.Forgot_Your_Password.click();
		wait.until(ExpectedConditions.visibilityOf(forgot.Forgot_Email));
		forgot.Forgot_Email.sendKeys("test@Test.com");
		forgot.Forgot_Submit.click();
		wait.until(ExpectedConditions.visibilityOf(forgot.Success_Message_Div));
		String Expected_Success_Message= "An email has been sent to the provided e-mail address with further instructions.";
		String Actual_Success_Message =forgot.Success_Message_Div.getText();
		System.out.println(Actual_Success_Message);
		if(Expected_Success_Message.equals(Actual_Success_Message))
		{
			Assert.assertTrue(true);
		}else
		{
			Assert.assertTrue(false);
		}
		
	}

	public void Forgot_Password_Invalid(WebDriver driver) {
		forgot.Forgot_Logo.click();
		wait.until(ExpectedConditions.visibilityOf(login.Forgot_Your_Password));
		login.Forgot_Your_Password.click();
		wait.until(ExpectedConditions.visibilityOf(forgot.Forgot_Email));
		forgot.Forgot_Email.sendKeys("Test@test");
		forgot.Forgot_Submit.click();
		wait.until(ExpectedConditions.visibilityOf(forgot.Alert_Message));
		String Expected_Alert_Message="Input validation failed";
		String Actual_Alert_message =forgot.Alert_Message.getText();
		System.out.println(Actual_Alert_message);
		if(Expected_Alert_Message.equals(Actual_Alert_message))
		{
			Assert.assertTrue(true);;
		}else
		{
			Assert.assertTrue(false);
		}
		
		
	}

	
	
	
	
	
	
	
	
}
