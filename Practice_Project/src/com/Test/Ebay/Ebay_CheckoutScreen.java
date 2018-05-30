package com.Test.Ebay;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Ebay_CheckoutScreen {
	
	private String selectedTvStringCompare = null;
	private String searchedTvStringCompare = null;
	private String selectedTvString = null;
	private String selectedTvPrice = null;
	private String checkoutScreen= "Delivery address";
	private String priceToCompare= null;
	private String checkoutScreenDescriptionXpath="//android.view.View[@index='3']/android.view.View[@index='2']/android.view.View[@index='1']/android.view.View[@index='1']/android.view.View[@index='0']/android.view.View[@index='0']";
	private String checkoutScreenPriceXpath="//android.widget.ListView[@index='3']/android.view.View[@index='3']";
	WaitOnProperty waitOnProperty = new WaitOnProperty();
	//Method to verify contents on Checkout Screen
	
	public boolean VerifiyingContentsOnCheckoutPage(AndroidDriver driver,String searchedTvString,String searchedTvPrice ) throws InterruptedException{
		
	Boolean status = false;
		

		waitOnProperty.WaitOnProperty(driver, 20);
	//driver.swipe(560, 1064, 560, 992, 200);
	 	checkoutScreen=driver.findElement(By.name("Delivery address")).getAttribute("text");
	 		waitOnProperty.WaitOnProperty(driver, 20);
	 			TouchAction ts = new TouchAction(driver);
	 				ts.press(0, 1400).waitAction(400).moveTo(0,400).release().perform();
	
	 				selectedTvString= driver.findElement(By.xpath(checkoutScreenDescriptionXpath)).getAttribute("text");
	 					System.out.println(selectedTvString);
	 						selectedTvPrice= driver.findElement(By.xpath(checkoutScreenPriceXpath)).getAttribute("text");
	 							System.out.println(selectedTvPrice);
	
	 								selectedTvStringCompare=selectedTvString.trim();
	 									searchedTvStringCompare=searchedTvString.trim();
	 										assertEquals(searchedTvStringCompare, selectedTvStringCompare);
	
	 											priceToCompare = searchedTvPrice.substring(1);
	 												System.out.println(priceToCompare);
	 													priceToCompare = "Rs. "+priceToCompare+".00";
	 														System.out.println(priceToCompare);
	 															assertEquals(priceToCompare, selectedTvPrice);
	
	
				
		    status = true;
		    
		return status;	
	}

}
