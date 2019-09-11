package com.seneca.appiumassessment.flipkart.tests;

import org.testng.annotations.Test;

import com.seneca.appiumassessment.flipkart.pageobject.LoginPageObjects;

public class WebViewTest {
	private static final String EMAIL_ID="sharath.thammisetty@gmail.com";
	LoginPageObjects login;
	
	@Test
	public void webviewTest() throws Exception{
		login=new LoginPageObjects();
		login.navigateToLoginPage();
		login.clickOnGoogle();
		login.switchToGoogleApp(EMAIL_ID);
	}
}
