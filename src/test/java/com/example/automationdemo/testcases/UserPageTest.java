package com.example.automationdemo.testcases;

import com.example.automationdemo.base.TestBase;
import com.example.automationdemo.pages.HomePage;
import com.example.automationdemo.pages.LoginPage;
import com.example.automationdemo.pages.UserPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserPageTest extends TestBase {
    HomePage homePage;
    UserPage userPage;
    LoginPage loginPage;

    public UserPageTest() {
        super();
    }

    @BeforeMethod
    public void seup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
        userPage=homePage.clickOnUserLink();
    }

    @Test(priority = 1)
    public void loginPageLogoTest() {
        userPage =  userPage.clickOnUser();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
