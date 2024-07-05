package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropdownPOM {

	public WebDriver driver;
	

	public DropdownPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;

	}
	
	@FindBy(id="demo_basic")
	public WebElement Basic;
	@FindBy(xpath="//select[@id='demo_groups']")
	public WebElement group;
	@FindBy(xpath="//select[@name='demo_native']")
	public WebElement Native;
	
	
	
	
	
	
	
	
	
	
	
	

}
