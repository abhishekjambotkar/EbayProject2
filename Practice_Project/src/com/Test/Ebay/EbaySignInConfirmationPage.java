package com.Test.Ebay;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

	

public class EbaySignInConfirmationPage {
	
	private String noThanksText = "No thanks";
	WaitOnProperty waitOnProperty = new WaitOnProperty();
	//Method to Tap on No Thanks
	public boolean SignInConfirmation(AndroidDriver driver) throws InterruptedException, NullPointerException{
		
		Boolean status = false;
		
			waitOnProperty.WaitOnProperty(driver, 20);
			driver.findElement(By.name(noThanksText)).click();
		
		status = true;
		
		return status;
		
	}

}
