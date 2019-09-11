package com.seneca.appiumassessment.flipkart.pageobject;

import java.util.List;

import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class FlipkartHomepage extends AbstractPageObject{
	@FindBy(id= "search_widget_textbox")
	AndroidElement element;
	
	@FindBy(id="search_autoCompleteTextView")
	AndroidElement searchBox;
	
	@FindBy(id="custom_search_cancel_id")
	AndroidElement cancelSearch;
	
	@FindBy(id="clear_text")
	AndroidElement clearText;
	
	@FindBy(className="android.widget.ImageButton")
	AndroidElement goBackButton;
	
	public void searchForProduct(String nameorcategory){
		tapOn(element);
		searchBox.sendKeys(nameorcategory);
		AndroidElement contextviewelement = driver.findElementsById("incorrect_login_text").get(0);
		contextviewelement.click();
	}

	public void clearTheSearchProduct(){
		cancelSearch.click();
		clearText.click();
	}

	public void searchAndCompareProduct() throws InterruptedException{
		boolean itemMatch=false;
		boolean	priceMatch=false;
		Thread.sleep(3000);
		for(int i=1;i<3;i++){

			AndroidElement itemnameOnSearchPage=waitForElementVisibility(By.xpath("(//android.widget.TextView[contains(@resource-id,'product_list_product_item_main_text')])["+i+"]"));
			String itemName=itemnameOnSearchPage.getText();

			AndroidElement priceOnSearchPage=waitForElementVisibility(By.xpath("(//android.widget.TextView[contains(@resource-id,'product_list_product_item_price')])["+i+"]"));
			String price=priceOnSearchPage.getText().substring(2);

			itemnameOnSearchPage.click();
			Thread.sleep(2000);
			List<AndroidElement> itemNamesinSku=driver.findElements(By.className("android.widget.TextView"));
			itemNamesinSku.size();
			for(WebElement item:itemNamesinSku){

				if(item.getText().contains(itemName)){
					itemMatch=true;
				}else if(item.getText().equals(price)){
					priceMatch=true;
				}
			}
			Assert.assertTrue(itemMatch);
			Assert.assertTrue(priceMatch);
			goBackButton.click();
		}
	}


	@Override
	public void navigateToPage() {

	}

	@Override
	public void assertInPage() {
	}
}
