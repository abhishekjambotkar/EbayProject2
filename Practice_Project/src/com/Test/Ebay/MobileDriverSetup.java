package com.Test.Ebay;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MobileDriverSetup {
	
	private static final int priority = 0;
	@SuppressWarnings("rawtypes")
	static
	AndroidDriver driver;
	public static void setup() throws Exception
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Ally galaxy 5");
		caps.setCapability("udid", "3208a71d704361e1"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0.1");
		caps.setCapability("appPackage", "com.ebay.mobile");
		caps.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");
		caps.setCapability("noReset", "true");
		
	
		
		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		//driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		System.out.println("app is launching");
	}
	

}
