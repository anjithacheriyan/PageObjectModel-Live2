package com.pages;

import com.base.Page;

public class DoLoginPage extends Page{




	
	public DoLoginPage() throws InterruptedException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ZohoAppPage doLoginPage(String user_id,String paswrd) throws InterruptedException{
	
		
		
		
		click("mailidTextBox");
		type("mailidTextBox",user_id);
		click("nextBtn");
		click("passwordBtn");
		type("passwordBtn",paswrd);
		click("nextBtn");
		
	return new ZohoAppPage();
	}
	
	
	
	
}
