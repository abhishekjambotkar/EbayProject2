package com.Test.Ebay;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class Ebay_SearchResultsPage {
	
	private String optionFromSearchedResultXpath= "//android.support.v7.widget.RecyclerView[@index='0']/android.widget.RelativeLayout[@index='1']";
	WaitOnProperty waitOnProperty = new WaitOnProperty();
	//Method to SelectAOption from obtained results
	public boolean SelectAOption(AndroidDriver driver) throws InterruptedException{
		
		Boolean status = false;
		
			waitOnProperty.WaitOnProperty(driver, 20);
				driver.findElement(By.xpath(optionFromSearchedResultXpath)).click();
					System.out.println("Option Selected");
				
		    status = true;
		return status;
		
	}

}
