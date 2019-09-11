package com.seneca.appiumassessment.flipkart.tests;

import org.testng.annotations.Test;

import com.seneca.appiumassessment.flipkart.pageobject.LoginPageObjects;

public class InternetConnectionTest {
	LoginPageObjects login;
	private static final String USER_NAME="sharath.thammisetty@gmail.com";
	
	@Test
	public void verifyApplicationwithoutNetworkTest() throws Exception{
		login=new LoginPageObjects();
		login.navigateToLoginPage();
		login.enterUserName(USER_NAME);
		login.enterPassword("sharath1247");
		login.enableInterNet(false);
		login.clickOnLogin();
		login.verifyNoInternetconnection();
		login.enableInterNet(true);
		Thread.sleep(5000);
		login.clickOnSkip();
		login.navigateToLoginPage();
		login.enterUserName(USER_NAME);
		login.enterPassword("sharath1247");
		login.clickOnLogin();
		login.verifyLogin(USER_NAME);
		login.clickOnMyAccount();
	}
}
