package com.seneca.appiumassessment.flipkart.tests;

import org.testng.annotations.Test;

import com.seneca.appiumassessment.flipkart.pageobject.FlipkartHomepage;
import com.seneca.appiumassessment.flipkart.pageobject.SearchProductsPage;
import com.seneca.appiumassessment.flipkart.pageobject.SwipserelatedPO;

public class SwipeActionTest {


	@Test
	public void searchProduct() throws Exception{

		FlipkartHomepage homepage = new FlipkartHomepage();
		homepage.searchForProduct("iphone");
		SearchProductsPage search=new SearchProductsPage();
		search.clickOnFirstItem();
		Thread.sleep(5000);
		SwipserelatedPO swipe=new SwipserelatedPO();
		swipe.horizontalSwipe();	
		swipe.verticalSwipe();
	}


}

