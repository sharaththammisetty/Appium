package com.seneca.appiumassessment.flipkart.pageobject;

import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SearchProductsPage extends AbstractPageObject {
	@FindBy(xpath="(//android.widget.TextView[contains(@resource-id,'product_list_product_item_main_text')])[1]")
	AndroidElement itemNameOnSearchPage;
	
	@FindBy(name="Back Button")
	AndroidElement goBackButton;
	
	@FindBy(id="sort_by_image")
	WebElement sortButton;
	
	@FindBy(id="clear_text")
	AndroidElement clearText;
	
	@FindBy(id="com.flipkart.android:id/back_icon")
	AndroidElement goBackFromSearch;
	
	public void clickOnFirstItem() throws Exception{
		Thread.sleep(3000);
		itemNameOnSearchPage.click();
	}
	
	public void gobackbutton() throws Exception{
		Thread.sleep(3000);
		goBackButton.click();
		Thread.sleep(3000);
		clearText.click();
		goBackFromSearch.click();
	}
	@Override
	public void navigateToPage() {

	}

	@Override
	public void assertInPage() {
		Assert.assertNotNull(sortButton, "Unable to navigate to Search Page");
	}

}
