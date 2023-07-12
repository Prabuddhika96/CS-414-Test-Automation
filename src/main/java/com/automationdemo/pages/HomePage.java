package com.automationdemo.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automationdemo.base.TestBase;



public class HomePage extends TestBase {
	
	
	
	
	//Page Factory - Object Repository
	
		@FindBy(xpath = "//a[@class='content tasks']")
		WebElement taskLink;
		
		@FindBy(xpath = "//a[@class='content reports']")
		WebElement reportsLink;
		
		@FindBy(xpath = "//div[@id='logo_aT']")
		WebElement actitimeLogo;
		
	
		
		//initialization
		
		public HomePage() {
			
			PageFactory.initElements(driver, this);
			
			
		}
		
		
		//Action/Methods
		
		public Boolean validateActiTimeLogo() {
			
			
			
			return actitimeLogo.isDisplayed();
			
			
		}
		
		
		
		public TasksPage clickOnTaskLink() {
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			taskLink.click();
			
			return new TasksPage();
			
		}
		
		
        public ReportsPage clickOnReportsLink() {
        	
        	try {
    			Thread.sleep(500);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
			
	         reportsLink.click();
	         
	         return new ReportsPage();
			
		}
	
}
