package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TransactionsPage extends BasePage{
	
	@FindBy(xpath="//a[@id='nav-transactions']")
	private WebElement navigateTransactions;
	
	private List<WebElement> getTransactionRows() {
		
		return driver.findElements(By.xpath("//table[@id='transactions-table']//tr"));
	}

	public TransactionsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	public void clickTransactions() {
		clickWhenVisible(navigateTransactions);

	}
	
	public void printTransactions() {
		
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//table[@id='transactions-table']/tbody/tr"),0));
		
		List<WebElement> rows = getTransactionRows();
		
		for(WebElement row:rows) {
			
			List<WebElement> cells = row.findElements(By.tagName("td"));
			
			if(cells.isEmpty()) {
				cells = row.findElements(By.tagName("th"));
			}
			for(WebElement cell:cells) {
				
				System.out.print(cell.getText()+"\t"+" ");
			}
			
			System.out.println();
		}
		
		

	}
	
}
