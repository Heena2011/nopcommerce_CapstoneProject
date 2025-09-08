package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {

	private ExtentSparkReporter sparkReporter;
	private ExtentReports extent;
	private static ThreadLocal<ExtentTest> tlTest = new ThreadLocal<>();
	private String repName;

	@Override
	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report_" + timeStamp + ".html";

		String reportPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + repName;
		sparkReporter = new ExtentSparkReporter(reportPath);

		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Functional Test Results");
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Application", "nopCommerce");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");

		String os = testContext.getCurrentXmlTest().getParameter("os");
		if (os != null)
			extent.setSystemInfo("Operating System", os);

		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		if (browser != null)
			extent.setSystemInfo("Browser", browser);

		List<String> includeGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if (!includeGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includeGroups.toString());
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		// Use method name and optionally description or a custom annotation value (TC
		// id) here
		String testName = result.getMethod().getMethodName();
		String description = result.getMethod().getDescription();
		ExtentTest test = (description == null || description.isEmpty()) ? extent.createTest(testName)
				: extent.createTest(testName + " - " + description);
		// If you have groups, assign them
		String[] groups = result.getMethod().getGroups();
		if (groups != null && groups.length > 0) {
			test.assignCategory(groups);
		}
		tlTest.set(test);
		tlTest.get().log(Status.INFO, "Test started: " + testName);
	}

//	@Override
//	public void onTestSuccess(ITestResult result) {
//		tlTest.get().log(Status.PASS, result.getMethod().getMethodName() + " - Passed");
//	}

	@Override
	public void onTestSuccess(ITestResult result) {
	    ExtentTest test = safeGetTest(result.getMethod().getMethodName());
	    test.log(Status.PASS, result.getMethod().getMethodName() + " - Passed");
	    tlTest.remove();
	}

	

	@Override
	public void onTestFailure(ITestResult result) {
	    ExtentTest test = safeGetTest(result.getMethod().getMethodName());
	    test.log(Status.FAIL, result.getMethod().getMethodName() + " - Failed");
	    test.log(Status.FAIL, "Reason: " + (result.getThrowable() != null ? result.getThrowable() : "No Throwable available"));

	    // Capture screenshot from the actual test instance's driver
	    try {
	        Object instance = result.getInstance();
	        if (instance instanceof BaseClass) {
	            BaseClass base = (BaseClass) instance;
	            String imgPath = base.captureScreen(result.getMethod().getMethodName());
	            if (imgPath != null) {
	                test.addScreenCaptureFromPath(imgPath);
	            } else {
	                test.warning("Screenshot path is null");
	            }
	        } else {
	            test.warning("Test instance is not of type BaseClass - cannot capture screenshot.");
	        }
	    } catch (Exception e) {
	        test.warning("Exception while taking screenshot: " + e.getMessage());
	    }
	}

	/*@Override
	public void onTestFailure(ITestResult result) {
		tlTest.get().log(Status.FAIL, result.getMethod().getMethodName() + " - Failed");
		tlTest.get().log(Status.FAIL, "Reason: " + result.getThrowable());

		// Capture screenshot from the actual test instance's driver
		try {
			Object instance = result.getInstance();
			if (instance instanceof BaseClass) {
				BaseClass base = (BaseClass) instance;
				String imgPath = base.captureScreen(result.getMethod().getMethodName());
				if (imgPath != null) {
					tlTest.get().addScreenCaptureFromPath(imgPath);
				} else {
					tlTest.get().warning("Screenshot path is null");
				}
			} else {
				tlTest.get().warning("Test instance is not of type BaseClass - cannot capture screenshot.");
			}
		} catch (Exception e) {
			tlTest.get().warning("Exception while taking screenshot: " + e.getMessage());
		}
	}*/
	@Override
	public void onTestSkipped(ITestResult result) {
	    ExtentTest test = safeGetTest(result.getMethod().getMethodName());
	    test.log(Status.SKIP, result.getMethod().getMethodName() + " - Skipped");
	    if (result.getThrowable() != null) test.log(Status.SKIP, "Skip reason: " + result.getThrowable());
	    tlTest.remove();
	}
//	@Override
//	public void onTestSkipped(ITestResult result) {
//		tlTest.get().log(Status.SKIP, result.getMethod().getMethodName() + " - Skipped");
//		if (result.getThrowable() != null) {
//			tlTest.get().log(Status.SKIP, "Skip reason: " + result.getThrowable());
//		}
//	}

	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush();

		// Open report automatically
		String extentReportPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator
				+ repName;
		try {
			Desktop.getDesktop().browse(new File(extentReportPath).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private ExtentTest safeGetTest(String fallbackName) {
		ExtentTest test = tlTest.get();
		if (test == null) {
			// create fallback so we won't NPE and failure is still recorded
			test = extent.createTest(fallbackName);
			tlTest.set(test);
			System.err.println("safeGetTest: created fallback ExtentTest for " + fallbackName);
		}
		return test;
	}
}
// Other ITestListener methods (no-op)
// onTestFailedButWithinSuccessPercentage / onTestFailedWithTimeout not needed
// explicitly}
