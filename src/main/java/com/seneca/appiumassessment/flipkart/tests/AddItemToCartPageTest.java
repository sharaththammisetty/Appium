package com.seneca.appiumassessment.flipkart.tests;

import org.testng.annotations.Test;

import com.seneca.appiumassessment.flipkart.pageobject.FlipKartAddToCartPageObject;
import com.seneca.appiumassessment.flipkart.pageobject.FlipkartHomepage;

public class AddItemToCartPageTest {
	
	
	@Test
	public void addToCartToCartandVerifyTest() throws Exception{
		FlipkartHomepage homepage = new FlipkartHomepage();
		homepage.searchForProduct("sony in Mobiles");
		FlipKartAddToCartPageObject addToCart=new FlipKartAddToCartPageObject();
		addToCart.addToCart();
		addToCart.verifyItemDeleteInCart();
		addToCart.clickOnShopNow();
	}
}
