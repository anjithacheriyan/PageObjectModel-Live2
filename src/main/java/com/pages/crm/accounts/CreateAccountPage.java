package com.pages.crm.accounts;

import com.base.Page;




public class CreateAccountPage extends Page{
	
	
	public CreateAccountPage() throws InterruptedException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public void createAccountPage(String accName) {
		
		type("accountNameTextBox",accName);
		
		
		
		
	}

}
