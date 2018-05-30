package com.Test.Ebay;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class EbayLandingPage {
	
	
		private String hamburgerResourceId = "com.ebay.mobile:id/home";
		private String signInResourceId = "com.ebay.mobile:id/logo";
		private String searchBoxResourceId="com.ebay.mobile:id/search_box";
		WaitOnProperty waitOnProperty = new WaitOnProperty();
	//Method to move from Landing Page to Sign In Page
	public boolean MoveToSigningPage(AndroidDriver driver) throws InterruptedException, NullPointerException{
		
		Boolean status = false;
	
			waitOnProperty.WaitOnProperty(driver, 20);
				System.out.println("On Landing page");
	
					driver.findElement(By.id(hamburgerResourceId)).click();
	
						waitOnProperty.WaitOnProperty(driver, 20);
							driver.findElement(By.id(signInResourceId)).click();
		
		status = true;
		
		return status;
	
	}
	//Method to Tap On Search Box
	public boolean TapOnSearchBox(AndroidDriver driver) throws InterruptedException, NullPointerException{
		
		Boolean status = false;
	
			waitOnProperty.WaitOnProperty(driver, 20);
				driver.findElement(By.id(searchBoxResourceId)).click();
				
		status = true;
		
		return status;
	
	}

}
