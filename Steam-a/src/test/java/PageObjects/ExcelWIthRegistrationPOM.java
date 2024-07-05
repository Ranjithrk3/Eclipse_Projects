package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExcelWIthRegistrationPOM {
	
	WebDriver driver;
	public ExcelWIthRegistrationPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(name="username")
	public WebElement UserID;
	@FindBy(name="password")
	public WebElement NewPassword;
	@FindBy(name="repeatedPassword")
	public WebElement RepeatPassword;
	@FindBy(name="account.firstName")
	public WebElement Firstname;
	@FindBy(name="account.lastName")
	public WebElement Lastname;
	@FindBy(name="account.email")
	public WebElement Email;
	@FindBy(name="account.phone")
	public WebElement Phone;
	@FindBy(name="account.address1")
	public WebElement Address1;
	@FindBy(name="account.address2")
	public WebElement Address2;
	@FindBy(name="account.city")
	public WebElement City;
	@FindBy(name="account.state")
	public WebElement State;
	@FindBy(name="account.zip")
	public WebElement Zip;
	@FindBy(name="account.country")
	public WebElement Country;
	@FindBy(name="newAccount")
	public WebElement SaveInfo;
	@FindBy(xpath="//a[text()='Sign In']")
	public WebElement SignIn;
	@FindBy(xpath="//a[text()='Register Now!']")
	public WebElement RegisterNow;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
