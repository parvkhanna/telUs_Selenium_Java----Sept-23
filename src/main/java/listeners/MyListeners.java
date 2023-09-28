package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener {

	
//	@Override
//	public void onStart(ITestContext context) {
//		//System.out.println("Execution Started");
//		ExtentReports extent = ExtentReports.generateReport();
//		
//	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		System.out.println("Execution of " + testName + " Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		 String testName = result.getName();
		 System.out.println(testName + " Executed Successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		 String testName = result.getName();
		 System.out.println(testName + " Failed");
		 System.out.println(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		 String testName = result.getName();
		 System.out.println(testName + " is skipped");
		 System.out.println(result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		 System.out.println("End of Execution");
	}

}
