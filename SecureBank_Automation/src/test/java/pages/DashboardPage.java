package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {
	
	
	//Locators using @FindBy
	
	@FindBy(id="total-balance")
	
	private WebElement totalBalance;
	
	
	@FindBy(id="accounts-count")
	
	private WebElement accountsCount;
	
	
	@FindBy(xpath="//table[@id='recent-transactions-table']//tr")
	
	private List<WebElement>  transactionRows;
	
	
	@FindBy(xpath="(//h3[text()='Primary Savings']/following-sibling::p)[1]")
	
	private WebElement primaryBalance;
	
	
	
	@FindBy(xpath="(//h3[text()='Primary Savings']/following-sibling::p)[2]")
	
	private WebElement primaryAccountDetails;
	
	
	
	@FindBy(xpath="(//h3[text()='Checking Account']/following-sibling::p)[1]")
	
	private WebElement checkingBalance;
	
	
	@FindBy(xpath="(//h3[text()='Checking Account']/following-sibling::p)[2]")
	
	private WebElement checkingAccountDetails;
	
	
	@FindBy(id="logout-btn")
	
	private WebElement logoutbtn;
	

	public DashboardPage(WebDriver driver) {
		
		super(driver);
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String getTotalBalance() {
		return getText(totalBalance);
	}
	
	
	public String getAccountsCount() {
		return getText(accountsCount);
	}
	
	
	public List<WebElement> getTransactionRows() {
		return transactionRows;
	}
	
	public String getPrimaryBalance() {
		return getText(primaryBalance);
	}
	
	public String getPrimaryAccountDetails() {
		return getText(primaryAccountDetails);
	}
	
	public String getCheckingBalance() {
		return getText(checkingBalance);
	}
	
	
	public String getCheckingAccountDetails() {
		return getText(checkingAccountDetails);
	}
	
	
	public void logout() {
		
		clickWhenVisible(logoutbtn);
	}

}
