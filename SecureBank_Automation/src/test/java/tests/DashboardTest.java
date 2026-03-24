package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ExtentReportManager;

public class DashboardTest extends BaseTest {
	
		@Test
		public void verifyDashboardDetails() {
			
			System.out.println("Extent instance exists? " + (ExtentReportManager.createInstance() != null));
			
			
			LoginPage login = new LoginPage(driver);
			
			DashboardPage dashboard = login.login(ConfigReader.get("username"),ConfigReader.get("password"));
			
			
			System.out.println("Total Balance:"+dashboard.getTotalBalance());
			
			System.out.println("Accounts count:"+dashboard.getAccountsCount());
			
			System.out.println("Recent Transactions");
			for(WebElement row:dashboard.getTransactionRows()) {
				
				System.out.println(row.getText());
			}
			
			System.out.println("Primary Savings Balance: " + dashboard.getPrimaryBalance());
	        
			System.out.println("Primary Savings Details: " + dashboard.getPrimaryAccountDetails());

	        System.out.println("Checking Balance: " + dashboard.getCheckingBalance());
	        System.out.println("Checking Details: " + dashboard.getCheckingAccountDetails());
	        
	        dashboard.logout();


		}
		

}
