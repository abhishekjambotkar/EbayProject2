package com.Test.Ebay;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

public class WaitOnProperty {
	
	@SuppressWarnings("rawtypes")
	
	//WaitOnProperty for Handling screen
	public void WaitOnProperty(AndroidDriver driver,Integer timeinSeconds){
		
		
		driver.manage().timeouts().implicitlyWait(timeinSeconds, TimeUnit.SECONDS);
		
		
	}

}
