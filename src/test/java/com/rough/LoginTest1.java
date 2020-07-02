package com.rough;

import com.base.Page;
import com.base.TopMenu;
import com.pages.HomePage;
import com.pages.DoLoginPage;
import com.pages.ZohoAppPage;
import com.pages.crm.accounts.CreateAccountPage;
import com.pages.crm.accounts.HomePageCRMAccounts;

public class LoginTest1 extends Page{

	public LoginTest1() throws InterruptedException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {
		
		
		HomePage homeopage=new HomePage();
		DoLoginPage login=homeopage.goToLogin();
		ZohoAppPage apppage=login.doLoginPage("anjithacheriyanmarate@gmail.com","Isabel@june30");
		apppage.crm();
		Thread.sleep(2000);
		TopMenu menu=new TopMenu(driver);
		menu.goToThreeDotsBtn();
		HomePageCRMAccounts hpAccounts=menu.gotoAccounts();
		CreateAccountPage creataccPg=hpAccounts.createAccountPlusBtn();
		creataccPg.createAccountPage("anji");
	}

}
