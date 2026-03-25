package base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ConfigReader;
import utils.ExtentReportManager;

public class BaseTest {

	protected WebDriver driver;
	private static ExtentReports extent;
	protected ExtentTest test;
	
	
	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void setUpReport() {
		
		System.out.println("===== [SUITE] @BeforeSuite started – thread " + Thread.currentThread().getId());
	   
	    
		
		extent = ExtentReportManager.createInstance();
		
		System.out.println("===== [SUITE] @BeforeSuite finished");
		
	}
	
	
	@BeforeMethod
	
	public void setUp(Method method){
		
		System.out.println("→ [METHOD] Starting " + method.getName() + "  (class: " + this.getClass().getSimpleName() + ")");
	    try {
		
		//to start test for each test method
		
		test = extent.createTest(method.getName());
		
		String browser = ConfigReader.get("browser");
		
		String url = ConfigReader.get("url");
		
		int implicitWait = Integer.parseInt(ConfigReader.get("timeout"));
		
		switch(browser.toLowerCase()) {
		
		
		case "chrome":
			
		
		    WebDriverManager.chromedriver().setup();

		    driver = new ChromeDriver();

		    break;

			
			
		case "edge":
			
			WebDriverManager.edgedriver().setup();
			
			driver = new EdgeDriver();
			
			break;
			
		case "firefox":
			
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();
			
			break;
			
		case "safari":
			driver = new SafariDriver();
			break;
		
		default:
			throw new InvalidArgumentException("Invalid browser Name"+browser);
		
		}
		
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		
		driver.get(url);
		
		System.out.println("→ [METHOD] @BeforeMethod finished OK");

	}
	    catch (Throwable t) {
	        System.err.println("!!! @BeforeMethod CRASHED for " + method.getName());
	        t.printStackTrace();
	        throw t;  
	    }
	    
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			
			test.fail("Test Failed: " +result.getThrowable());
		}
		else if (result.getStatus()==ITestResult.SKIP) {
			
			test.skip("Test Skipped:"+result.getThrowable());
			
		}
		else {
			
			test.pass("Test Passed");
			
		}
		
		
	
		
	}
	
	@AfterSuite
	public void tearDownSuite() {
	    if (driver != null) {
	        driver.quit();
	        System.out.println("Browser closed after entire suite");
	    }
	}
	
	@AfterSuite
	public void flushReport() {
		
		extent.flush();

	}
	
	
	
}
