package com.Test.Ebay;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class EbaySearchScreen {
	
		private String SearchBoxText="Search for anything";
		private String searchOptionDropdownXpath= "//android.widget.ListView[@index='1']/android.widget.RelativeLayout[@index='0']"; 
		WaitOnProperty waitOnProperty = new WaitOnProperty();
	
	// Methos to Enter Search Option
	public boolean EnterSearchOption(AndroidDriver driver, String searchItem) throws InterruptedException, NullPointerException{
		
		Boolean status = false;
		
			System.out.println("On Search Screen");
		
			waitOnProperty.WaitOnProperty(driver, 20);
			driver.findElement(By.name(SearchBoxText)).sendKeys(searchItem);
			System.out.println("Search Options");
			
			    status = true;
	    return status;
	    
	}
	
	public boolean SelectFromSearchDropBox(AndroidDriver driver) throws InterruptedException, NullPointerException{
		
		Boolean status = false;
		
			waitOnProperty.WaitOnProperty(driver, 20);
			driver.findElement(By.xpath(searchOptionDropdownXpath)).click();
			System.out.println("Search Results");
					
			    status = true;
	    return status;
	    
	}

}
