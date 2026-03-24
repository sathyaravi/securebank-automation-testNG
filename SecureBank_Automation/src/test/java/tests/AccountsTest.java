package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountsPage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

public class AccountsTest extends BaseTest{
	
	@Test
	public void verifyAccountPage() {
		
		LoginPage login = new LoginPage(driver);
		
		login.login(ConfigReader.get("username"),ConfigReader.get("password"));
		
		AccountsPage accounts = new AccountsPage(driver);
		
		accounts.clickAccounts();
		
		accounts.searchAccountName("Primary Savings");
		
		accounts.printAccountsTable();
		
		accounts.resetFilters();
		
		
		


	}
	@AfterMethod
	public void afterMethod() {
	    DashboardPage dashboard = new DashboardPage(driver);
	    dashboard.logout();
	    driver.quit();
	}
	
	
	

}
