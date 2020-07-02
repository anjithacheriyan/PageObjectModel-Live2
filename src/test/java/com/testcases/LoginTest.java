package com.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.HomePage;
import com.pages.DoLoginPage;
import com.pages.ZohoAppPage;
import com.utilities.TestUtil;

public class LoginTest extends BaseTest {

	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")	
	public void loginTest(Hashtable <String,String> data) throws InterruptedException {
	HomePage homeopage=new HomePage();
	Thread.sleep(2000);
	DoLoginPage login=homeopage.goToLogin();
	ZohoAppPage apppage=login.doLoginPage(data.get("userid"),data.get("password"));
	
	
	}
}
