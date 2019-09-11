package com.seneca.appiumassessment.flipkart.pageobject;

import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.HasNetworkConnection;

import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects extends AbstractPageObject {
	
	@FindBy(xpath="//android.widget.ImageButton")
	AndroidElement dashbaordButton;
	
	@FindBy(id="com.flipkart.android:id/title_action_bar")
	AndroidElement titleOfPage;
	
	@FindBy(id="com.flipkart.android:id/btn_skip")
	AndroidElement skipButton;
	
	@FindBy(id="com.flipkart.android:id/mobileNo")
	AndroidElement email;
	
	@FindBy(id="com.flipkart.android:id/forgot")
	AndroidElement forgetLink;
	
	@FindBy(id="com.flipkart.android:id/et_password")
	AndroidElement passWord;
	
	@FindBy(id="com.flipkart.android:id/btn_mlogin")
	AndroidElement loginButton;
	
	@FindBy(id="com.flipkart.android:id/pageLevelError")
	AndroidElement noInternetText;
	
	@FindBy(id="com.flipkart.android:id/pageLevelError")
	AndroidElement loginFailureMsg;
	
	@FindBy(xpath="//android.widget.TextView[contains(text(),'Forgot?')]")
	AndroidElement forgotLink;
	
	@FindBy(id="com.flipkart.android:id/btn_login_google")
	AndroidElement googleLink;
	
	@FindBy(id="Email")
	AndroidElement emailBox;
	
	@FindBy(id="com.flipkart.android:id/tv_resend_code")
	AndroidElement enterCode;
	
	@FindBy(id="android:id/big_text")
	AndroidElement notificationLink;
	
	@FindBy(xpath="//android.widget.LinearLayout[1]")
	AndroidElement codeEnterField;
	
	@FindBy(id="com.flipkart.android:id/et_password")
	AndroidElement newPasswordField;
	
	@FindBy(xpath="//android.widget.EditText[contains(@resource-id,'Email')]")
	AndroidElement emailFeild;
	
	@FindBy(name="Open Drawer")
	AndroidElement myAccount;
	
	public void navigateToLoginPage() throws Exception{
		Thread.sleep(5000);
		if(dashbaordButton.isDisplayed()){
		dashbaordButton.click();
		}
		scrollTo("My Account");
		List<AndroidElement> Textlinks=driver.findElements(By.xpath("//android.widget.TextView"));
		System.out.println(Textlinks.size());
		for(WebElement Textlink :Textlinks){
			if(Textlink.getText().equals("My Account")){
				Textlink.click();
				break;
			}
		}
	}

	public void verifyLogin(String username) throws Exception {
		Thread.sleep(2000);
		System.out.println(titleOfPage.getText());
		Assert.assertEquals(titleOfPage.getText(), "My Account");
		List<AndroidElement> views=driver.findElements(By.xpath("//android.view.View"));
		System.out.println(views.size());
		for(WebElement view:views){
			System.out.println(view.getAttribute("name"));
			if(view.getAttribute("name").equals(username)){
				break;
			}
		}
	}

	public void clickOnMyAccount() throws Exception{
		Thread.sleep(3000);
		myAccount.click();
	}
	
	public void logOut(){
		driver.scrollTo("Logout");
		List<AndroidElement> views=driver.findElements(By.xpath("//android.view.View"));
		System.out.println(views.size());
		for(WebElement view:views){
			System.out.println(view.getAttribute("name"));
			if(view.getAttribute("name").equals("Logout")){
				view.click();
				break;
			}
		}

	}
	public void clickOnSkip() throws Exception{
		Thread.sleep(2000);
		skipButton.click();
	}



	public void enableInterNet(boolean isEnabled) throws InterruptedException {
		NetworkConnectionSetting networkConnection = new NetworkConnectionSetting(false, isEnabled, false);
		((HasNetworkConnection) driver).setNetworkConnection(networkConnection);
	}

	public void enterUserName(String username) throws Exception{
		Thread.sleep(2000);
		email.clear();
		email.sendKeys(username);
	}

	public void clickOnForgetLink() throws Exception{
		Thread.sleep(2000);
		forgetLink.click();
	}
	public void enterPassword(String password) throws Exception{
		Thread.sleep(2000);
		passWord.sendKeys(password);
	}

	public void clickOnLogin() throws Exception{
		Thread.sleep(3000);
		loginButton.click();
	}

	public void verifyNoInternetconnection(){
		Assert.assertEquals(noInternetText.getText(), "Request timed out. Please check your network connection and try again");

	}

	public void verifyWithInvalidData() throws Exception{
		Assert.assertEquals(loginFailureMsg.getText(),"Invalid login details");
	}

	public void clearPasswordField() throws Exception{
		email.clear();
		Thread.sleep(3000);
		passWord.clear();
	}

	public void clickonForgot(){
		forgotLink.click();
	}

	public void enterEmailidONWebView(String username){
		emailBox.sendKeys(username);
	}

	public String handleNotifications() throws InterruptedException{
		String notificationmsg=null ,oTP = null;
		Thread.sleep(2000);
		enterCode.click();
		Thread.sleep(8000);
		((AndroidDriver<AndroidElement>) driver).openNotifications();
		Thread.sleep(5000);
		notificationmsg=notificationLink.getText();
		System.out.println(notificationmsg);
		Thread.sleep(3000);
		if(notificationmsg.contains("Flipkart verification"))
		{
			oTP = notificationmsg.substring(0, 6);
			driver.navigate().back();
		}
		else
		{
			System.out.println("Not a Flipkart Notification");
		}
		return oTP;
	}
	
	public void sendTheOtp(String otp){
		codeEnterField=waitForElementVisibility(By.xpath(""));
		codeEnterField.sendKeys(otp);
	}
	
	public void verifyTheOtp() throws Exception{
		Thread.sleep(3000);
		Assert.assertTrue(newPasswordField.isDisplayed());
	}

	public void clickOnGoogle(){
		googleLink.click();
	}

	public void switchToGoogleApp(String emailid) throws InterruptedException {
		Thread.sleep(5000);
		Set<String> contextHandles = driver.getContextHandles();
		for (String contextName : contextHandles) {
			System.out.println(contextHandles.size());
			System.out.println(contextName);
			if (contextName.contains("NATIVE_APP")) {		
				emailFeild.sendKeys(emailid);
				Thread.sleep(2000);
				driver.hideKeyboard();
			}
		}
		Thread.sleep(4000);
		driver.navigate().back();

	}

	@Override
	public void navigateToPage() {

	}

	@Override
	public void assertInPage() {

	}


}
