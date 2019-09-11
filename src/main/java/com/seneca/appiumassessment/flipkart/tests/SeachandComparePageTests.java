package com.seneca.appiumassessment.flipkart.tests;

import org.testng.annotations.Test;

import com.seneca.appiumassessment.flipkart.pageobject.FlipkartHomepage;
import com.seneca.appiumassessment.flipkart.pageobject.SearchProductsPage;


public  class SeachandComparePageTests {
	private static final String SEARCH_ITEM="Lenovo";
	@Test
	public void searchProductAndCompareTest() throws Exception{

		FlipkartHomepage homepage = new FlipkartHomepage();
		homepage.searchForProduct(SEARCH_ITEM);
		homepage.searchAndCompareProduct();
		SearchProductsPage searchproduct=new SearchProductsPage();
		searchproduct.gobackbutton();
	}
}
