package com.seneca.appiumassessment.flipkart.pageobject;


import java.util.List;

import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class FlipKartAddToCartPageObject extends AbstractPageObject{

	@FindBy(xpath="(//android.widget.TextView[contains(@resource-id,'product_list_product_item_main_text')])[1]")
	AndroidElement itemNameOnSearchPage;

	@FindBy(xpath="(//android.widget.TextView[contains(@resource-id,'product_list_product_item_price')])[1])")
	AndroidElement priceOnSearchPage;


	@FindBy(xpath="//android.widget.TextView[@index='0']")
	AndroidElement itemNamesInSku;

	@FindBy(id="product_addtocart_1")
	AndroidElement addToCartButton;

	@FindBy(id="cart_icon")
	AndroidElement cartIcon;

	@FindBy(name="REMOVE")
	AndroidElement removeButtonOnCart;

	@FindBy(name="SHOP NOW")
	AndroidElement shopNow;

	public void addToCart() throws Exception{
		String con;

		Thread.sleep(3000);
		String itemName=itemNameOnSearchPage.getText();
		System.out.println(itemName);
		String price=priceOnSearchPage.getText().substring(2);
		System.out.println(price);
		itemNameOnSearchPage.click();
		itemNamesInSku.getText();
		String itemOnSku=itemNamesInSku.getText();
		Thread.sleep(5000);
		if(addToCartButton.getText().equals("ADD TO CART")){
			addToCartButton.click();
			Thread.sleep(4000);
			cartIcon.click();
			Thread.sleep(20000);
			List<AndroidElement> count=driver.findElements(By.xpath("//android.view.View"));
			System.out.println(count.size());
			for(WebElement con1:count) {
				try {
					con = con1.getAttribute("name");
					if (!con.isEmpty())
					{
						if(con.equals(itemOnSku))
						{
							System.out.println("Item Matches");
						}
						else if(con.substring(1).equals(price))
						{
							removeButtonOnCart.click();
							Thread.sleep(5000);
							break;
						}

					}

				}
				catch (Exception e){}
			}
		}
	}

	public void verifyItemDeleteInCart() throws InterruptedException{
		boolean emptycartmsg=false;	
		Thread.sleep(10000);
		List<AndroidElement> cart=driver.findElements(By.xpath("//android.view.View"));
		System.out.println(cart.size());
		Thread.sleep(2000);
		for(WebElement cartemptymsg : cart){
			try {
				if (!cartemptymsg.getAttribute("name").isEmpty())
				{
					System.out.println(cartemptymsg.getAttribute("name"));
					Thread.sleep(1000);
					if(cartemptymsg.getAttribute("name").contains("Your Cart is empty!"))
					{
						emptycartmsg=true;
					}

				}
			}
			catch (Exception e){}
		}

		Assert.assertTrue(emptycartmsg);
	}

	public void clickOnShopNow() throws InterruptedException{
		Thread.sleep(2000);
		shopNow.click();
		Thread.sleep(3000);
	}

	@Override
	public void navigateToPage() {

	}

	@Override
	public void assertInPage() {

	}

}
