package Nova.resources;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsTEST 
{
	public static ExtentReports GetReports()
	{
		String path=System.getProperty("user.dir")+"\\Reports\\Results.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Automation Results");
		reporter.config().setReportName("Test Results");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Name", "Dharanidhar");
		return extent;
	}
	

}
