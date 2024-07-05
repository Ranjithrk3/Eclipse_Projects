package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forgot_Password_POM {
	
	WebDriver driver;

	
	public Forgot_Password_POM(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver=driver;
	
	}
	
	@FindBy(xpath="//div[@class='card-header text-center bg-dark']//img[@class='block-center rounded']")
	public WebElement Forgot_Logo;
	@FindBy(xpath="//input[@id='email']")
	public WebElement Forgot_Email;
	@FindBy(xpath="//button[@type='submit']")
	public WebElement Forgot_Submit;
	@FindBy(xpath="//div[@class='alert alert-success text-center mt-1 ng-star-inserted']")
	public WebElement Success_Message_Div;//Content : An email has been sent to the provided e-mail address with further instructions.
	@FindBy(xpath="//div[@class='alert alert-danger text-center mt-1 ng-star-inserted']")
	public WebElement Alert_Message;
	
	
	
	
}
