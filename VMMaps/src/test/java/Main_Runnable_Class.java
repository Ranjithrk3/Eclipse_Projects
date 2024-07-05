import org.testng.annotations.Test;

import TestClass.BaseClass;
import TestClass.Forgot_Password_Class;
import TestClass.Register_Class;

public class Main_Runnable_Class extends BaseClass {
	public Forgot_Password_Class forgot_class;
	public Register_Class register;
	
	
	@Test(priority=0)
	public void Register() throws InterruptedException
	{
		register=new Register_Class(driver);
		register. Register_Method(driver);
	}
	
		
	@Test(priority = 1)
	public void ForgotPassword_Valid_Email() {
		forgot_class = new Forgot_Password_Class(driver);
		forgot_class.Forgot_Password_Valid(driver);
	}

	@Test(priority = 2)
	public void ForgotPassword_Invalid_Email() {
		forgot_class = new Forgot_Password_Class(driver);
		forgot_class.Forgot_Password_Invalid(driver);
	}

	

}
