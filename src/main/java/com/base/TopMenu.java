package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.crm.accounts.HomePageCRMAccounts;


public class TopMenu {
	
	
	
	
	public  WebDriver driver;

	public TopMenu(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	WebElement threedotmenu;


	public void goToThreeDotsBtn(){
		
		Page.click("goToThreeDotsBtn]");
		
		
		
	}
	
	
	public void gotoContacts(){
		
		
	}

	public HomePageCRMAccounts gotoAccounts() throws InterruptedException {
		
	Page.click("goToAccounts");		
	
	return new HomePageCRMAccounts();
	}

	
	public void gotoLeads(){
		
		
	}
	
		
	public void gotoDeals(){
		
		
	}
	public void gotoActivities(){
		
		
	}
	
	public void gotoProducts(){
		
		
	}







}

