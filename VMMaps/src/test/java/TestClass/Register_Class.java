package TestClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import POM_Pages.Login_POM;
import POM_Pages.Register_POM;


	public class Register_Class extends BaseClass {
		WebDriver driver;
		public Login_POM login;
		public Register_POM register;
		public WebDriverWait wait;


	public Register_Class(WebDriver driver) {
	this.driver=driver;
	login = new Login_POM(driver);
	register= new Register_POM(driver);
	wait=new WebDriverWait(driver,Duration.ofSeconds(60));
	
}
	public void Register_Method(WebDriver driver ) throws InterruptedException
	{
	driver.get("https://petstore.octoperf.com/actions/Account.action?newAccountForm=");
	
	
		
	}






}
