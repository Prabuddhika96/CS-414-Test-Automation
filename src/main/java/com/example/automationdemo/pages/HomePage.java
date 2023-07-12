package com.example.automationdemo.pages;

import com.example.automationdemo.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
	//Page Factory - Object Repository
	@FindBy(xpath = "//a[@class='content tasks']")
	WebElement taskLink;
	@FindBy(xpath = "//a[@class='content reports']")
	WebElement reportsLink;
	@FindBy(xpath = "//a[@class='content users']")
	WebElement userLink;
		
	//initialization
	public HomePage() {
		PageFactory.initElements(driver, this);
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

	//	public UserPage clickOn
	public UserPage clickOnUserLink() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			System.out.println(e.toString());
		}
		userLink.click();
		return new UserPage();
	}
}
