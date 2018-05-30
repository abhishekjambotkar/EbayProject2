package com.Test.Ebay;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class EbayReviewPage {
	
	public String selectedTvString = null;
	public String selectedTvPrice = null;
	private String selectedTvStringResourceId = "com.ebay.mobile:id/item_title";
	private String selectedTvPriceResourceId = "com.ebay.mobile:id/textview_item_price";
	WaitOnProperty waitOnProperty = new WaitOnProperty();
	//Method to Verify contents on Review Screen and Tapping on Buy 
	public boolean ComparingStringAndTapOnReview(AndroidDriver driver, String searchedTvString, String searchedTvPrice) throws InterruptedException, NullPointerException{
		
		Boolean status = false;
		

			waitOnProperty.WaitOnProperty(driver, 20);
			System.out.println("Selected Option Review Page");
			selectedTvString= driver.findElement(By.id(selectedTvStringResourceId)).getAttribute("text");
			System.out.println(selectedTvString);
			selectedTvPrice= driver.findElement(By.id(selectedTvPriceResourceId)).getAttribute("text");
			System.out.println(selectedTvPrice);
			assertEquals(searchedTvString, selectedTvString);
			assertEquals(searchedTvPrice, selectedTvPrice);
			driver.findElement(By.name("Review")).click();
	
				
		    status = true;
		return status;	
	}

}
