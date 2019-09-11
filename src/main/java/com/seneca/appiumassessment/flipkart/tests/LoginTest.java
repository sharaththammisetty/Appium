package com.seneca.appiumassessment.flipkart.tests;

import org.testng.annotations.Test;

import com.seneca.appiumassessment.flipkart.pageobject.LoginPageObjects;

public class LoginTest {
	LoginPageObjects login;
	private static final String USER_NAME="sharath.thammisetty@gmail.com";
	
	@Test
	public void loginwithInvalidTest() throws Exception{
		login=new LoginPageObjects();
		login.navigateToLoginPage();
		login.enterUserName(USER_NAME);
		login.enterPassword("sharath1246");
		login.clickOnLogin();
		login.verifyWithInvalidData();
		login.clickOnSkip();
	}

	@Test
	public void loginwithvalidData() throws Exception{
		login.navigateToLoginPage();
		login.enterUserName(USER_NAME);
		login.enterPassword("sharath1247");
		login.clickOnLogin();
	}

	@Test
	public void verifyLogin() throws Exception{
		login.verifyLogin(USER_NAME);
		login.logOut();
	}
}
