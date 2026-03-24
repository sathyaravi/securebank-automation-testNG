package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		
		this.driver=driver;
		
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	
	protected WebElement waitForVisibility(WebElement element) {
		
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	protected WebElement waitForClickable(WebElement element) {
		
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public void clickWhenVisible(WebElement element) {
	    wait.until(ExpectedConditions.visibilityOf(element));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	    element.click();
	}
	
	public void click(WebElement element) {
		
		waitForClickable(element).click();

	}
	
	
	public String type(WebElement element,String text) {
		
		WebElement el = waitForVisibility(element);
		
		el.clear();
		
		el.sendKeys(text);
		return text;
		
		
	}
	
	
	public String getText(WebElement element) {
		
		return waitForVisibility(element).getText();
	}
	
	
	
	
	
	
	
}
