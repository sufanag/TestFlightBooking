package com.goibibo.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.goibibo.base.BaseClass;
import com.goibibo.base.Driver;
import com.goibibo.base.TestBase;

public class SearchPage extends TestBase{
	
	HomePage homepage = null;
	SearchPage searchpage;
	
	
	public SearchPage() {
	
		PageFactory.initElements(driver1, this);
	}
	
	
	
	public void selectFlight() {
		
		String xpathVal="//*[@data-cy='bookBtn']";
		WebDriverWait wait = new WebDriverWait(driver1,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathVal)));
	
	
		

		 List<WebElement> a= driver1.findElements(By.xpath(xpathVal)) ;
		 a.get(0).click();
		
		 driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public boolean verifytcktDetails() {
		
		return driver1.findElement(By.cssSelector("[class='bkHeaderMsg mobdn']")).isDisplayed();
	}
	
	
}
