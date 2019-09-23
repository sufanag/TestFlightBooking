package com.goibibo.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.goibibo.base.BaseClass;
import com.goibibo.base.Driver;
import com.goibibo.base.TestBase;
import com.qa.util.ReadExcelData;

public class HomePage extends TestBase{
	
	
	ReadExcelData r = new ReadExcelData();
	 
	String fromCity;
	String toCity;

	SearchPage searchpage = null;
	
	WebElement drpdown; 

	@FindBy(id="gosuggest_inputSrc")
	WebElement From_City;
	
	@FindBy(css="#gosuggest_inputDest")
	WebElement To_City;
	
	
	@FindBy(id="gi_search_btn")
	WebElement searchBtn;
	
	public HomePage() {
		PageFactory.initElements(driver1, this);
	}
	
	
	public void jsDatePicker(){
		
		try {
		String xpathVal="//*[@id='departureCalendar']";
		
		WebDriverWait wait = new WebDriverWait(driver1,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathVal)));
		WebElement depDate = driver1.findElement(By.xpath(xpathVal));
		
		depDate.click();
		driver1.findElement(By.xpath("//div[@id='fare_20190926']")).click();
		//depDate.sendKeys("20190912");
		Thread.sleep(2000);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//depDate.sendKeys(Keys.RETURN,Keys.ESCAPE);
		
	}
	
	
	public SearchPage enterFlightDetails() throws Exception {
		System.out.println("Test started");
		
		fromCity = r.getMapData("From_City");
		System.out.println("City Name: "+fromCity);
		
		//WebElement From_City = driver.findElement(By.id("gosuggest_inputSrc"));
		From_City.sendKeys(fromCity);
		Thread.sleep(2000);
			
		
		From_City.sendKeys(Keys.ARROW_DOWN,Keys.ENTER,Keys.ESCAPE );
	
		Thread.sleep(2000);
		
		toCity = r.getMapData("To_City");
		
		To_City.sendKeys(toCity);
		
		Thread.sleep(2000);
		
		To_City.sendKeys(Keys.ARROW_DOWN,Keys.ENTER,Keys.ESCAPE );
			Thread.sleep(2000);
			jsDatePicker();
		
		
		searchBtn.click();
		
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return new SearchPage();
		
		
	}
	
	
	/*
	 * public void verifyTest() {
	 * 
	 * WebElement text = driver1.findElement(By.
	 * cssSelector("#filterContainer > div.stickyHpy.pad20 > div:nth-child(2) > div:nth-child(1) > div > div.black.fb.ico14.padB10.quicks"
	 * )); Assert.assertEquals(text.getText(),
	 * "Departure","Search page title is :"+text.getText());
	 * 
	 * 
	 * 
	 * }
	 */
	 
	

}
