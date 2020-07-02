package com.listeners;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.base.Page;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.MonitoringMail;
import com.utilities.TestConfig;
import com.utilities.TestUtil;

public class CustomListeners extends Page implements ITestListener,ISuiteListener {

	public CustomListeners() throws InterruptedException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		test= rep.startTest(result.getName().toUpperCase());
		
		System.out.println(result.getName());
		if(!TestUtil.isRunnable(result.getName())) {
			
			System.out.println((TestUtil.isRunnable(result.getName())));
			throw new SkipException("Skipping the TestCase:"+result.getName().toUpperCase());
			
			
		}
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		test.log(LogStatus.PASS, result.getName().toUpperCase()+"pass");
		rep.endTest(test);
		rep.flush();
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("FAILED TESTCASE :click the link to see screenshot");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		test.log(LogStatus.FAIL, result.getName().toUpperCase()+"fail");
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
		
		
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+">Error Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img scr="+TestUtil.screenshotName+">Error Screenshot</a>");
		
	   rep.endTest(test);
	   rep.flush();
	 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

		test.log(LogStatus.SKIP,result.getName().toUpperCase()+"Skipping the testcase");
		rep.endTest(test);
		rep.flush();
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		MonitoringMail mail= new MonitoringMail();
		
		String messagebody="/Users/anji/eclipse-UdemyTrainings/PageObjectModelBasic/target/surefire-reports/html/extent.html";
		
		
		
					try {
						mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messagebody);
					} catch (AddressException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
	}


					
	}
}