package com.pages.crm.accounts;

import com.base.Page;

public class HomePageCRMAccounts extends Page {

	public HomePageCRMAccounts() throws InterruptedException {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateAccountPage createAccountPlusBtn() throws InterruptedException {
		
		click("createAccountPlusBtn");
		Thread.sleep(2000);
		
		return new CreateAccountPage();
	}
	
	public void importBtn() {
		
		
		
	}
	
	
	
	
	
}
