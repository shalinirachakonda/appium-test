package org.ets.selenium.tests.iviewer_selenium_regression_tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends SetTear{	
	
	@Test
	public void assertSuccessfulLogin() {
		Login login= new Login(driver);
		login.loginToApp();
		//Assert.assertEquals
		
	}
	
}
