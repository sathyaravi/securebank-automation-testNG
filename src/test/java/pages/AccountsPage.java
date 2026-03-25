package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountsPage extends BasePage {

	@FindBy(xpath="//a[@id='nav-accounts']")
	private WebElement navigateAccounts;
	
	@FindBy(id="search-input")
	private WebElement searchAccount;
	
	@FindBy(id="reset-filters-btn")
	private WebElement resetFiltersButton; 
	
	private List<WebElement> getTableRows() {
	    return driver.findElements(By.xpath("//table[@id='accounts-table']//tr"));
	}

	
	public AccountsPage(WebDriver driver) {
		
		super(driver);
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickAccounts() {
		
		clickWhenVisible(navigateAccounts);
		

	}
	
	public void searchAccountName(String accountName) {
		type(searchAccount, accountName);
	}
	
	

	
	public void printAccountsTable() {
		
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
		        By.xpath("//table[@id='accounts-table']/tbody/tr"), 0));

		List<WebElement> rows =getTableRows();
		
		for(WebElement row:rows) {
			
			List <WebElement> cells = row.findElements(By.tagName("td"));
			
			if (cells.isEmpty()) {
				cells = row.findElements(By.tagName("th"));
			}
			for(WebElement cell:cells) {
				
				System.out.print(cell.getText()+"\t"+"  ");
			}
			
			System.out.println();
		}

	}
	
	public void resetFilters() {
		
		click(resetFiltersButton);

	}
	
}
