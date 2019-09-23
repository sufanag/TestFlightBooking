package com.goibibo.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	// private static final DriverManagerType CHROME = null;
	public static WebDriver driver1;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	WebEventListener eventlistener;

	public static void initialization() throws IOException {

		String filepath = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\goibibo\\properties\\config.properties";
		System.out.println(filepath);
		// WebDriverManager.getInstance(CHROME).setup();

		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		// driver = new ChromeDriver();

		FileInputStream fin = new FileInputStream(filepath);
		prop = new Properties();
		prop.load(fin);

	}

	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver1 = new ChromeDriver();

		e_driver = new EventFiringWebDriver(driver1);
		eventlistener = new WebEventListener();
		e_driver.register(eventlistener);
		driver1 = e_driver;

		driver1.get(prop.getProperty("url"));
		driver1.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver1.manage().window().maximize();
	}

	
	  public void takeScreenshot() { File srcFile =
	  ((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE); try{
	  FileUtils.copyFile(srcFile, new
	  File(System.getProperty("user.dir")+"\\screenshots\\failure.jpg")); }
	  catch(Exception e) {
	  
	  } }
	 

}
