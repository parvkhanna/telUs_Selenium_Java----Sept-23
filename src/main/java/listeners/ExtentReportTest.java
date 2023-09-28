package listeners;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

	public class ExtentReportTest {
	    private ExtentReports extent;
	    private ExtentTest test;

	    @BeforeSuite
	    public void setUp() {
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./test-reports/ExtentReport.html");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	    }

	    @BeforeMethod
	    public void beforeMethod() {
	        test = extent.createTest(getClass().getSimpleName());
	    }

	    @AfterMethod
	    public void afterMethod(ITestResult result) {
	        if (result.getStatus() == ITestResult.FAILURE) {
	            test.log(Status.FAIL, "Test case failed: " + result.getName());
	        } else if (result.getStatus() == ITestResult.SUCCESS) {
	            test.log(Status.PASS, "Test case passed: " + result.getName());
	        } else if (result.getStatus() == ITestResult.SKIP) {
	            test.log(Status.SKIP, "Test case skipped: " + result.getName());
	        }
	    }

	    @AfterSuite
	    public void tearDown() {
	        extent.flush();
	    }
	}



