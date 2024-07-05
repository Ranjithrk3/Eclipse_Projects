package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_POM {

	WebDriver driver;
	
	
	
	
	public Login_POM(WebDriver driver ) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
		
	}
	
	@FindBy(xpath="//img[@class='block-center rounded logo-text']")
	public WebElement Logo;
	@FindBy(xpath="//input[@id='email']")
	public WebElement Email;
	@FindBy(xpath="//input[@id='password']")
	public WebElement Password;
	@FindBy(xpath="//button[@type='submit']")
	public WebElement SignIn;
	@FindBy(xpath="//a[text()='Forgot your password?']")
	public WebElement Forgot_Your_Password;
	@FindBy(xpath="//a[text()='No account yet? Create one']")
	public WebElement Register_CreateOne;
	@FindBy(xpath="//a[text()='Privacy Policy']")
	public WebElement Privacy_Policy;
	
	
}
