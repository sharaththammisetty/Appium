package com.seneca.appiumassessment.flipkart.tests;

import org.testng.annotations.Test;

import com.seneca.appiumassessment.flipkart.pageobject.LoginPageObjects;

public class NotificationsTest {
	LoginPageObjects login;
	private static final String USER_NAME="9177412755";
	private String OTP;
	

	@Test
	public void notificationsTest() throws Exception{
		login=new LoginPageObjects();
		login.navigateToLoginPage();
		login.enterUserName(USER_NAME);
		login.clickOnForgetLink();
		Thread.sleep(2000);
		OTP=login.handleNotifications();
		login.sendTheOtp(OTP);
		login.verifyTheOtp();
	}

	
}
