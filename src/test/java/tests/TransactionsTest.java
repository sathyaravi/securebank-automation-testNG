package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import pages.TransactionsPage;
import utils.ConfigReader;

public class TransactionsTest extends BaseTest {
	
	@Test
	public void verifyTransactionDetails() {
		
		LoginPage login = new LoginPage(driver);
		
		login.login(ConfigReader.get("username"),ConfigReader.get("password"));
		
		TransactionsPage transaction = new TransactionsPage(driver);
		
		
		transaction.clickTransactions();
		
		transaction.printTransactions();
		
		

	}
	@AfterMethod
	public void afterMethod() {
	    DashboardPage dashboard = new DashboardPage(driver);
	    dashboard.logout();
	    driver.quit();
	}

}
