package com.goibibo.base;

import java.beans.EventHandler;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.qa.ExtentReportListener.LogStatus;
import com.qa.util.ReadPropertyFile;
import com.qa.util.WebEventListener;


/**
 * 
 * @author asakthiv
 * Driver class is used to start browsers based on the property file input.
 * User gets the option to work on firefox and chrome browser.
 * Private constructor to avoid external initialisation	
 */

public class Driver {

	public static WebDriver driver=null;

	public Driver() 
	{
		String browser=ReadPropertyFile.get("browser");
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--incognito");
				DesiredCapabilities capabilities= new DesiredCapabilities();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver=new ChromeDriver();
			}
			/*
			 * else if(browser.equalsIgnoreCase("firefox")) {
			 * System.setProperty("webdriver.gecko.driver",
			 * ".//src/test/resources/geckodriver.exe"); FirefoxOptions FFoptions= new
			 * FirefoxOptions(); FFoptions.addArguments("--incognito"); driver= new
			 * FirefoxDriver(FFoptions); }
			 */
		}
		catch (Exception e) {
			LogStatus.fail(e);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(ReadPropertyFile.get("WaitTime")), TimeUnit.SECONDS);
		EventHandlerInit();
		driver.get(ReadPropertyFile.get("url"));
		driver.manage().deleteAllCookies();
	}

	public static void initialize() {
		new Driver();
	}

	public static void quit() {
		if(driver!=null) {
			driver.quit();
		}
	}


	/*
	 * Used to listen to driver events
	 */

	private void EventHandlerInit() {
		EventFiringWebDriver eventhandle = new EventFiringWebDriver(driver);
		WebEventListener capture= new WebEventListener();
		eventhandle.register(capture);
		driver=eventhandle;
	}



}
