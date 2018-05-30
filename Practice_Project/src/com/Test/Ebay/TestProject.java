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
		static AndroidDriver driver;
		private String searchedTvString = null;
		private String searchedTvPrice = null;
		FileInput files= new FileInput();
		EbayLandingPage ebayLandingPage = new  EbayLandingPage();
		EbaySignInPage ebaySignInPage = new EbaySignInPage();
		EbaySignInConfirmationPage ebaySignInConfirmationPage = new EbaySignInConfirmationPage();
		EbaySearchScreen ebaySearchScreen = new EbaySearchScreen();
		EbaySearchResultsPage ebaySearchResultsPage = new EbaySearchResultsPage();
		EbaySearchedOptionPage ebaySearchedOptionPage = new EbaySearchedOptionPage();
		EbayReviewPage ebayReviewPage = new EbayReviewPage();
		EbayCheckoutScreen ebayCheckoutScreen = new EbayCheckoutScreen();
		
		
		
		@BeforeClass
		public static void setup() throws Exception
		{
			
			MobileDriverSetup mobiledriver = new MobileDriverSetup();
			
			//Method to create the mobile driver session
			mobiledriver.setup();
			driver=mobiledriver.driver;
			
		}
		
		//@org.testng.annotations.Test
		@Test
		public void test_Scenario1_Pass() throws Exception {
			
			
			//data from excel sheet
			String username = files.Username();
			String password = files.Password(); 
			String searchItem = files.SearchItem();
			
			//Method to Sign In Page from Landing page
			ebayLandingPage.MoveToSigningPage(driver);
			
			//Method to Enter the Username and password on Sign In Page
			ebaySignInPage.EnterDetailsOnSign(driver, username, password);
		
			//Method to confirm login
			ebaySignInConfirmationPage.SignInConfirmation(driver);
			
			//Method to Tap on SearchBox
			ebayLandingPage.TapOnSearchBox(driver);
		
			//Method to Enter value in SearchBox
			ebaySearchScreen.EnterSearchOption(driver, searchItem);
			
			//Method to select an option from Searched Dropdown Menu
			ebaySearchScreen.SelectFromSearchDropBox(driver);
			
			//Method to Select an option
			ebaySearchResultsPage.SelectAOption(driver);
			
			//Method to obtain String details of selected device and Tap on Buy
			ebaySearchedOptionPage.SavingStringAndTapOnBuy(driver);
			searchedTvString = ebaySearchedOptionPage.searchedTvString;
			searchedTvPrice = ebaySearchedOptionPage.searchedTvPrice;
		
			//Method to obtain verify details of selected device on Review Screen and Tap on Review
			ebayReviewPage.ComparingStringAndTapOnReview(driver, searchedTvString, searchedTvPrice);
			
			//Method to obtain verify details of selected device on Checkout Screen and Tap on Review
			ebayCheckoutScreen.VerifiyingContentsOnCheckoutPage(driver, searchedTvString, searchedTvPrice);
			
			
			}
		

		
		@After
		public void teardown()
		{
			System.out.println("closing the session");
			
		}
		
	}







