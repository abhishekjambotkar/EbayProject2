package com.Test.Ebay;



import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString;


import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class TestProject {
	
		private static final int priority = 0;
		@SuppressWarnings("rawtypes")
		static
		AndroidDriver driver;
		private String searchedTvString = null;
		private String searchedTvPrice = null;
		private String selectedTvString = null;
		private String selectedTvPrice = null;
		private String selectedTvStringCompare = null;
		private String searchedTvStringCompare = null;
		private String checkoutScreen= "Delivery address";
		private String priceToCompare= null; 

		
		
		@BeforeClass
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
		
		//@org.testng.annotations.Test
		@Test
		public void test_Scenario1_Pass() throws Exception {
			
			String FilePath = "D:\\Workspace\\UnifiedScripting\\Practice_Project\\data\\RDC.xls";// excel path
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(0);//To get access of sheet1 
			String Username = sh.getCell(0,1).getContents();
			String Password = sh.getCell(1,1).getContents();
			String SearchItem = sh.getCell(2,1).getContents();
			System.out.println("Username: "+Username);
			System.out.println("Password: "+Password);
			System.out.println("SearchItem: "+SearchItem);
			
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			System.out.println("On Landing page");
			
			
			driver.findElement(By.id("com.ebay.mobile:id/home")).click();
			
			Thread.sleep(100);
			driver.findElement(By.id("com.ebay.mobile:id/logo")).click();
			
			Thread.sleep(2000);
			System.out.println("On login page");
			driver.findElement(By.id("com.ebay.mobile:id/edit_text_username")).sendKeys(Username);
			Thread.sleep(2000);
			driver.findElement(By.id("com.ebay.mobile:id/edit_text_password")).sendKeys(Password);
			Thread.sleep(2000);
			driver.findElement(By.id("com.ebay.mobile:id/button_sign_in")).click();
			Thread.sleep(2000);
			driver.findElement(By.name("No thanks")).click();
			
			Thread.sleep(2000);
			driver.findElement(By.id("com.ebay.mobile:id/search_box")).click();
			System.out.println("On Search Screen");
			
			Thread.sleep(100);
			driver.findElement(By.name("Search for anything")).sendKeys(SearchItem);
			System.out.println("Search Options");
			
			Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.ListView[@index='1']/android.widget.RelativeLayout[@index='0']")).click();
			System.out.println("Search Results");
			
			Thread.sleep(200);
			driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='0']/android.widget.RelativeLayout[@index='1']")).click();
			System.out.println("Option Selected");
			
			Thread.sleep(200);
			System.out.println("Selected Option");
			searchedTvString= driver.findElement(By.id("com.ebay.mobile:id/textview_item_name")).getAttribute("text");
			System.out.println(searchedTvString);
			searchedTvPrice= driver.findElement(By.id("com.ebay.mobile:id/textview_item_price")).getAttribute("text");
			System.out.println(searchedTvPrice);
			driver.findElement(By.name("Buy it now")).click();
			
			Thread.sleep(200);
			System.out.println("Selected Option Review Page");
			selectedTvString= driver.findElement(By.id("com.ebay.mobile:id/item_title")).getAttribute("text");
			System.out.println(selectedTvString);
			selectedTvPrice= driver.findElement(By.id("com.ebay.mobile:id/textview_item_price")).getAttribute("text");
			System.out.println(selectedTvPrice);
			assertEquals(searchedTvString, selectedTvString);
			assertEquals(searchedTvPrice, selectedTvPrice);
			driver.findElement(By.name("Review")).click();
			
			Thread.sleep(10000);
			//driver.swipe(560, 1064, 560, 992, 200);
			 checkoutScreen=driver.findElement(By.name("Delivery address")).getAttribute("text");
			 Thread.sleep(10000);
			TouchAction ts = new TouchAction(driver);
			ts.press(0, 1400).waitAction(400).moveTo(0,400).release().perform();
			
			selectedTvString= driver.findElement(By.xpath("//android.view.View[@index='3']/android.view.View[@index='2']/android.view.View[@index='1']/android.view.View[@index='1']/android.view.View[@index='0']/android.view.View[@index='0']")).getAttribute("text");
			System.out.println(selectedTvString);
			selectedTvPrice= driver.findElement(By.xpath("//android.widget.ListView[@index='3']/android.view.View[@index='3']")).getAttribute("text");
			System.out.println(selectedTvPrice);
			
			selectedTvStringCompare=selectedTvString.trim();
			searchedTvStringCompare=searchedTvString.trim();
			assertEquals(searchedTvStringCompare, selectedTvStringCompare);
			
			priceToCompare = searchedTvPrice.substring(1);
			System.out.println(priceToCompare);
			priceToCompare = "Rs. "+priceToCompare+".00";
			System.out.println(priceToCompare);
			assertEquals(priceToCompare, selectedTvPrice);
			
			}
		

		
		@After
		public void teardown()
		{
			System.out.println("closing the session");
			
		}
		
	}







