package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	
	
	@FindBy(name="username")
	WebElement username;
	
	
	@FindBy(name="password")
	
	WebElement password;
	
	
	@FindBy(xpath="//button[text()='Login']")
	
	WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		
		super(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	public DashboardPage login(String user,String  pass) {
		
		type(username,user);
		
		type(password,pass);
		
		click(loginBtn);
		
		return new DashboardPage(driver);
		
		
	}
	

	
	
	
	
	
	
	

}
