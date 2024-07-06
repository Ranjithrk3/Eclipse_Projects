package RunnableClass;

import java.io.IOException;

import org.testng.annotations.Test;

import TestClass.AlertBox;
import TestClass.BaseClass;
import TestClass.Dropdown;
import TestClass.ExcelWithRegistration;

public class RunnableClass extends BaseClass {

	@Test(priority = 0)
	public void ExcelTestCase() throws IOException {
		ExcelWithRegistration xl = new ExcelWithRegistration();
		xl.ExcelFunction();
	}

	@Test(priority = 1)
	public void DropdownTestcase() throws IOException {
		Dropdown dd = new Dropdown(driver, extent);
		dd.DropdownFunction();

	}

	@Test(priority = 2)
	public void AlertboxTestCase() throws IOException {
		AlertBox alrt = new AlertBox(driver, extent);
		alrt.AlertboxFunction();

	}

}
