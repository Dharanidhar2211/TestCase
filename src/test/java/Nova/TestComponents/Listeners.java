package Nova.TestComponents;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Nova.resources.ExtentReportsTEST;

public class Listeners extends BaseTest implements ITestListener {
	ExtentReports extent = ExtentReportsTEST.GetReports();
	ExtentTest test;

	public void onTestStart(ITestResult result) 
	{
		test=extent.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS, result.getMethod().getMethodName());
		

	}

	public void onTestFailure(ITestResult result) 
	{
		test.fail(result.getThrowable());
		test.log(Status.FAIL,result.getMethod().getMethodName());
		
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		String path=null;
		try {
			path = GetScreenShot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) 
	{
		extent.flush();

	}

}
