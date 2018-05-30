package com.Test.Ebay;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class EbaySearchedOptionPage {
	
	public String searchedTvString = null;
	public String searchedTvPrice = null;
	private String buyItNowResourceId = "Buy it now";
	private String searchedTvStringResourceId = "com.ebay.mobile:id/textview_item_name";
	private String searchedTvPriceResourceId = "com.ebay.mobile:id/textview_item_price";
	WaitOnProperty waitOnProperty = new WaitOnProperty();
	// Method to save the content searched and tappin on buy
	public boolean SavingStringAndTapOnBuy(AndroidDriver driver) throws InterruptedException, NullPointerException{
		
	Boolean status = false;
		
		waitOnProperty.WaitOnProperty(driver, 20);
			System.out.println("Selected Option");
					searchedTvString= driver.findElement(By.id(searchedTvStringResourceId)).getAttribute("text");
						System.out.println(searchedTvString);
							searchedTvPrice= driver.findElement(By.id(searchedTvPriceResourceId)).getAttribute("text");
								System.out.println(searchedTvPrice);
									driver.findElement(By.name(buyItNowResourceId)).click();
	
				
		    status = true;
		return status;
		
	}

}
