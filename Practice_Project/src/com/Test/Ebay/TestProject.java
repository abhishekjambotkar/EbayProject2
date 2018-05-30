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
		EbayLandingPage ebay_LandingPage = new  EbayLandingPage();
		EbaySignInPage ebay_SignInPage = new EbaySignInPage();
		EbaySignInConfirmationPage ebay_SignInConfirmationPage = new EbaySignInConfirmationPage();
		EbaySearchScreen ebay_SearchScreen = new EbaySearchScreen();
		EbaySearchResultsPage ebay_SearchResultsPage = new EbaySearchResultsPage();
		EbaySearchedOptionPage ebay_SearchedOptionPage = new EbaySearchedOptionPage();
		EbayReviewPage ebay_ReviewPage = new EbayReviewPage();
		EbayCheckoutScreen ebay_CheckoutScreen = new EbayCheckoutScreen();
		
		
		
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
			ebay_LandingPage.MoveToSigningPage(driver);
			
			//Method to Enter the Username and password on Sign In Page
			ebay_SignInPage.EnterDetailsOnSign(driver, username, password);
		
			//Method to confirm login
			ebay_SignInConfirmationPage.SignInConfirmation(driver);
			
			//Method to Tap on SearchBox
			ebay_LandingPage.TapOnSearchBox(driver);
		
			//Method to Enter value in SearchBox
			ebay_SearchScreen.EnterSearchOption(driver, searchItem);
			
			//Method to select an option from Searched Dropdown Menu
			ebay_SearchScreen.SelectFromSearchDropBox(driver);
			
			//Method to Select an option
			ebay_SearchResultsPage.SelectAOption(driver);
			
			//Method to obtain String details of selected device and Tap on Buy
			ebay_SearchedOptionPage.SavingStringAndTapOnBuy(driver);
			searchedTvString = ebay_SearchedOptionPage.searchedTvString;
			searchedTvPrice = ebay_SearchedOptionPage.searchedTvPrice;
		
			//Method to obtain verify details of selected device on Review Screen and Tap on Review
			ebay_ReviewPage.ComparingStringAndTapOnReview(driver, searchedTvString, searchedTvPrice);
			
			//Method to obtain verify details of selected device on Checkout Screen and Tap on Review
			ebay_CheckoutScreen.VerifiyingContentsOnCheckoutPage(driver, searchedTvString, searchedTvPrice);
			
			
			}
		

		
		@After
		public void teardown()
		{
			System.out.println("closing the session");
			
		}
		
	}







