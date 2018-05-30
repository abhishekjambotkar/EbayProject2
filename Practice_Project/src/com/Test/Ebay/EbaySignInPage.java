package com.Test.Ebay;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class EbaySignInPage {
	
	private String usernameResourceId="com.ebay.mobile:id/edit_text_username";
	private String passwordResourceId="com.ebay.mobile:id/edit_text_password";
	private String sigInButtonResourceId="com.ebay.mobile:id/button_sign_in";
	
	WaitOnProperty waitOnProperty = new WaitOnProperty();
	
	//Method to enter details on Sign In Page
	public boolean EnterDetailsOnSign(AndroidDriver driver, String username, String password) throws InterruptedException{
		
		Boolean status = false;
		
			waitOnProperty.WaitOnProperty(driver, 20);
				System.out.println("On login page");
					driver.findElement(By.id(usernameResourceId)).sendKeys(username);
					waitOnProperty.WaitOnProperty(driver, 5);
							driver.findElement(By.id(passwordResourceId)).sendKeys(password);
							waitOnProperty.WaitOnProperty(driver, 5);
									driver.findElement(By.id(sigInButtonResourceId)).click();
		
		status =true;
		
		return status;
	}

}
