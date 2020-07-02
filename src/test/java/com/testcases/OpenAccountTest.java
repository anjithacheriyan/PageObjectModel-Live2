package com.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.base.Page;
import com.pages.ZohoAppPage;
import com.pages.crm.accounts.CreateAccountPage;
import com.pages.crm.accounts.HomePageCRMAccounts;
import com.utilities.TestUtil;




public class OpenAccountTest extends BaseTest {
	
	



	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void openAccountTest(Hashtable <String,String> data) throws InterruptedException {

	ZohoAppPage apppage=new ZohoAppPage();
	apppage.crm();
	HomePageCRMAccounts hpAccounts=Page.menu.gotoAccounts();
	CreateAccountPage creataccPg=hpAccounts.createAccountPlusBtn();
	creataccPg.createAccountPage(data.get("accountName"));
	
	Page.quit();
	}
}
