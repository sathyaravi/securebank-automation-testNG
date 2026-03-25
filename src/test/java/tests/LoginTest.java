package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {
	
	@Test
	public void testValidLogin() {
		
		LoginPage login = new LoginPage(driver);
		
		DashboardPage dashboard = login.login(ConfigReader.get("username"),ConfigReader.get("password"));
		
		
		Assert.assertTrue(dashboard.getTotalBalance().contains("$"), 
                "Login failed or dashboard not loaded");


	}
	@AfterMethod
	public void afterMethod() {
	    DashboardPage dashboard = new DashboardPage(driver);
	    dashboard.logout();
	    driver.quit();
	}
	

}
