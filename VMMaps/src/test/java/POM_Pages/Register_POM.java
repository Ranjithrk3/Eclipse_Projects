package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register_POM {

	
	WebDriver driver;
	
	public Register_POM(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;

	}
	@FindBy(xpath="//input[@id='firstName']")
	public WebElement Firstname;
	@FindBy(xpath="//input[@id='lastName']")
	public WebElement Lastname;
	@FindBy(xpath="//input[@id='email']")
	public WebElement Email;
	@FindBy(xpath="//input[@id='password']")
	public WebElement Password;
	@FindBy(xpath="//input[@id='verifyPassword']")
	public WebElement Re_Enter_Password;
	@FindBy(xpath="//input[@id='company']")
	public WebElement Company;
	@FindBy(xpath="//input[@id='serialNumber']")
	public WebElement Serial_Number;
	@FindBy(xpath="//div[@id='mat-select-value-1']")
	public WebElement Select_Region_DropDown;//need to find options
	@FindBy(xpath="//input[@id='mat-checkbox-1-input']")
	public WebElement Terms_and_Condition_Checkbox;
	@FindBy(xpath="//input[@id='mat-checkbox-2-input']")
	public WebElement Privacy_Policy_Checkbox;
	@FindBy(xpath="//button[@type='submit']")
	public WebElement Register_SignUp;
	@FindBy(xpath="//a[text()='Already a member? Login']")
	public WebElement Already_a_Member_Login;
	
	
	
}
