package com.example.automationdemo.testcases;

import com.example.automationdemo.base.TestBase;
import com.example.automationdemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.automationdemo.pages.HomePage;
import com.example.automationdemo.utils.TestUtil;



public class LogonPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	String sheetName = "Users";
	TestUtil testUtil;
	
	
	
	public LogonPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void seup() {
		initialization();
		loginPage = new LoginPage();
	}
	
	
	@Test(priority = 1)
	public void loginPageLogoTest() {
		boolean flag= loginPage.validateActiTimeLogo();
		Assert.assertTrue(flag);
	}
	
	
	@DataProvider
	
	public Object[][] getactiTimeTestData() {
		Object data[][]=testUtil.getTestData(sheetName);
		
		return data;
		
		
		
	}
	@Test(priority = 2,dataProvider="getactiTimeTestData")
	public void LoginTest(String userName, String password) {
		homePage = loginPage.loging(userName, password);
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
