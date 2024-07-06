package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertboxPOM {
	
	public WebDriver driver;

	public AlertboxPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;

	}
	//Using ID
	@FindBy(id="alertButton")
	public WebElement SimpleAlert;
	
	//Xpath using index method
	@FindBy(xpath="(//button[@class='btn btn-primary'])[2]")
	public WebElement TimeDelayedAlert;
	
	//XPath using text() and Index
	@FindBy(xpath="(//button[text()='Click me'])[3]")
	public WebElement ConfirmationAlert;
	
	//Xpath using Id 
	@FindBy(xpath="//button[@id='promtButton']")
	public WebElement PromptAlert;
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	

}
