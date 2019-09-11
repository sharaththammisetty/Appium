package com.seneca.appiumassessment.flipkart.pageobject;

import io.appium.java_client.android.AndroidElement;

import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.FindBy;

public  class SwipserelatedPO extends AbstractPageObject{
	Dimension size;
	
	@FindBy(xpath="//android.widget.TextView[@index='0']")
	AndroidElement itemNameInSku;

	@FindBy(xpath="//android.widget.TextView[@index='0']")
	AndroidElement itemNameInSkuAfterSwipe;
	
	@FindBy(xpath="cart_icon")
	AndroidElement cartIcon;
	
	public void horizontalSwipe() throws Exception {
		//Get the size of screen.
		size = driver.manage().window().getSize();
		System.out.println(size);
		int startx = (int) (size.width * 0.90);
		int endx = (int) (size.width * 0.10);
		int starty = size.height / 2;
		String itemOnSku=itemNameInSku.getText();
		driver.swipe(startx, starty, endx, starty, 3000);
		Thread.sleep(5000);
		Assert.assertNotSame(itemNameInSkuAfterSwipe.getText(), itemOnSku);
		driver.swipe(endx, starty, startx, starty, 3000);
		Thread.sleep(5000);
		Assert.assertTrue(itemNameInSku.getText().equals(itemOnSku));
	}

	public void verticalSwipe() throws Exception {
		size = driver.manage().window().getSize();
		System.out.println(size);
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		driver.swipe(startx, starty, startx, endy, 3000);
		Thread.sleep(2000);
		Assert.assertTrue(!cartIcon.isDisplayed());
		driver.swipe(startx, endy, startx, starty, 3000);
		Thread.sleep(2000);
		Assert.assertTrue(cartIcon.isDisplayed());
	}

	@Override
	public void navigateToPage() {

	}

	@Override
	public void assertInPage() {
	}

}
