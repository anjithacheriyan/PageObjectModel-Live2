package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.Status;
import com.listeners.CustomListeners;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.ExcelReader;
import com.utilities.ExtentManager;
import com.utilities.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {

	public static WebDriver driver;
	public static Properties config=new Properties();
	public static Properties OR=new Properties();
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel=new ExcelReader("/Users/anji/eclipse-UdemyTrainings/PageObjectModelBasic/src/test/resources/excel/testdata.xlsx");
	public static WebDriverWait wait;
	public static TopMenu menu=new TopMenu(driver);
	public static String browser;
	public  ExtentReports rep=ExtentManager.getInstance();
	public static ExtentTest test;

	public Page() throws InterruptedException {
		
		
		if(driver==null) {
			
			try {
				fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//properties//Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				config.load(fis);
				log.debug(config);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			try {
				fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//properties//OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug(OR);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()){
				
				browser=System.getenv("browser");
			       																	 }
			else {
			
					
				browser=config.getProperty("browser");
				
			     }
			
			    config.setProperty("browser",browser);
			
			
			
			
			if(config.getProperty("browser").equals("Chrome")) {
				
				//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//executables//chromedriver");
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			
				log.debug("Chrome launched !!!");
			
			}else if(config.getProperty("browser").equals("Safari")){ 
	
				driver=new SafariDriver();
				log.debug("Safari launched !!!");
			
				
		}
			
	
		
		driver.get(config.getProperty("testurl"));
		log.debug(config.getProperty("testurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
		}
		
	}
	
	

	
	public  static Boolean IsElementPrsent(By by) {
		
		try {
				driver.findElement(by);
				return true;
		    }
			
		catch(NoSuchElementException e) {
			
			
			return false;
		}
		
	}
	
	
	
	public void verifyEquals(String expected,String actual) throws IOException {
		
		try {
			Assert.assertEquals(actual, expected);
		}
		catch(Throwable t) {
			
		TestUtil.captureScreenshot();
		//reportng
		Reporter.log("<br>"+"Verification Failed:"+t.getMessage()+"<br>");	
		Reporter.log("<br>");	
		Reporter.log("<br>");	
		Reporter.log("<br><target=\"_blank\">"+"<href="+TestUtil.screenshotName+">"+"<img src="+TestUtil.screenshotName+">"+"<br>");	
			
		//extentReport
				test.log(LogStatus.FAIL,"Verification failed with exception"+t.getMessage());
				test.log(LogStatus.INFO, test.addScreenCapture(TestUtil.screenshotName));
				
		
		}
		
		
		
	}
	
	
	public static void click(String locator){
		
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
		test.log(LogStatus.INFO, "Clicking on:"+locator);
		
	}
	
	
	public void type(String locator,String value) {
		
		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		test.log(LogStatus.INFO, "typing on:"+locator);
		
	}
	
	
	public void waitForVisibility(String locator){
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(locator))));
			test.log(LogStatus.INFO, "Waiting for:"+locator);
			
		}
	
	
	static WebElement dropdown;
	public void select(String locator,String value){
		
		dropdown=driver.findElement(By.xpath(OR.getProperty(locator)));
		test.log(LogStatus.INFO, "selecting dropdown :"+locator);
		
		Select select=new Select(dropdown);
		select.selectByVisibleText(value);
		test.log(LogStatus.INFO, "selecting value :"+value);
		
	}
		
		@AfterSuite
		public static void quit() {
		if(driver!=null) {
			
			driver.quit();
			log.debug("browser closed !!!");
			
		}
	
		
		
	}

	
	
	
	
	
	
	
}


	
