package com.pages;

import com.base.Page;

public class HomePage extends Page {
	
	


	public HomePage() throws InterruptedException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void goToSignUp() {
		click("signUpBtn");
		
	}
	
	public DoLoginPage goToLogin() throws InterruptedException {
		click("loginBtn");
		return new DoLoginPage();
	}
	
	public void goToSupport() {
		click("supportBtn");
	}
	
	public void goToZohoEdu() {
		
		
	}
	
	public void goToLearnMore() {
			
			
		}
	public void validateFooterLinks() {
		
		
	}

	
}
