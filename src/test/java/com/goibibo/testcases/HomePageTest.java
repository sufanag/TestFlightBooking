package com.goibibo.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.goibibo.base.TestBase;
import com.goibibo.pages.HomePage;
import com.goibibo.pages.SearchPage;
import com.qa.ExtentReportListener.ExtentTestManager;

	

public class HomePageTest extends TestBase{
	
	HomePage homepage;
	SearchPage searchpage;
	 
	public HomePageTest(){
		super();
	}

	 
	 @BeforeTest
	 public void startMethod() throws IOException {
		 initialization();
		 setUp();
		 
		 homepage = new HomePage();
		
	 }
	 
	 @Test(priority=1)
	 public void flightDetails(Method method) throws Exception {
		 
		 //Thread.sleep(4000);
		 searchpage = homepage.enterFlightDetails();
		 
		 ExtentTestManager.startTest(method.getName(), "Searching for suitable flight with flight details");
		 
		 
		 
	 }
	 
 
	
	  @AfterTest public void tearDown() 
	  { driver1.quit();
	 
	  }
	 
	 
}
