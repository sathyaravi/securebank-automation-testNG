package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports createInstance() {
		
		ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
		
		reporter.config().setReportName("SecureBank Automation");
		
		reporter.config().setDocumentTitle("Automation Test Results");
		
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Tester", "Sathya");
		
		extent.setSystemInfo("Environment", "QA");
		
		
		return extent;
		
		
		
	}

}
