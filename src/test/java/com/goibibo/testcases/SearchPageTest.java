package com.goibibo.testcases;


import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.goibibo.base.BaseClass;
import com.goibibo.base.Driver;
import com.goibibo.base.TestBase;
import com.goibibo.pages.HomePage;
import com.goibibo.pages.SearchPage;
import com.qa.ExtentReportListener.ExtentTestManager;

public class SearchPageTest extends TestBase{
	
	HomePage homepage;
	SearchPage searchpage;
	
	
	
	
	@BeforeTest
	public void setupTest() throws Exception{
		
		initialization();
		 setUp();
		 
	
		homepage = new HomePage();
		searchpage = homepage.enterFlightDetails();
		 
		//ExtentTestManager.startTest(method.getName(), "Launching flight details");
	}
	
	@Test(priority=2)
	public void searchandBookFlight(Method method) {
		searchpage.selectFlight();
		
		 ExtentTestManager.startTest(method.getName(), "Entering flight details and searching");
			
				
	}	
	
	@Test(priority=3)
	public void verify(Method method) {
		Assert.assertTrue(searchpage.verifytcktDetails());
		ExtentTestManager.startTest(method.getName(), "Verifying flight details");
		
		
	}
	
	
	  @AfterTest 
	  public void tearDown() { 
		  driver1.quit(); 
	  
	  }
	 
	  
		
}
