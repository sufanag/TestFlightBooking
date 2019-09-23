package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.goibibo.base.TestBase;
import com.utils.ReadPropertyFile;

import Analyzer.Listeners;



public class TestUtils extends TestBase {
	
	
	/*
	 * Captures screenshot and returns the screenshot path
	 */
	public static String pullScreenshotPath()  {

		String destination=null;
		if(ReadPropertyFile.get("ScreenshotsRequired").equalsIgnoreCase("yes")) {
			File scrFile = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
			try {
				String screenshotPath = "";
				if(screenshotPath.equals("")) {

					destination=System.getProperty("user.dir")+"\\screenshots\\" +Listeners.TestcaseName+"\\"+ System.currentTimeMillis() + ".png";
					FileUtils.copyFile(scrFile, new File(destination));
				}
				else {
					destination=screenshotPath+"\\screenshots\\" +Listeners.TestcaseName.replaceAll(" ","")+"\\"+ System.currentTimeMillis() + ".png";
					FileUtils.copyFile(scrFile, new File(destination));
				}

			}
			catch(Exception e) {
				e.printStackTrace();

			}

		}
		System.out.println(destination);
		return destination;

	}

	
	/*
	 * Gives a base64 image which is used to append the screenshots in the extent report.
	 * Converting to base64 format avoids screenshots broken image if sent the exent report through email.
	 */
	public static String getBase64Image(String screenshotpath) {
		String base64 = null;
		try {
			InputStream is= new FileInputStream(screenshotpath);
			byte[] imageBytes = IOUtils.toByteArray(is);
			base64 = Base64.getEncoder().encodeToString(imageBytes);
		}
		catch (Exception e) {

		}
		return base64;

	}
	/*
	 * Reads the data from the excel sheet and store the values in respective lists which will be used in annotation transformer class
	 */

	/*
	 * public static void getRunStatus() throws Exception { try { fs=new
	 * FileInputStream(ReadPropertyFile.get("TestDataLocation")); workbook=new
	 * XSSFWorkbook(fs); sheet=workbook.getSheet("RunManager"); for(int
	 * i=1;i<=getLastRowNum("RunManager");i++) {
	 * //rowAndTestCaseMap.put(i,sheet.getRow(i).getCell(0).getStringCellValue().
	 * toString()); testCases.add(getCellContent("RunManager", i, "TestCaseName"));
	 * testDescription.add(getCellContent("RunManager", i,
	 * "Test Case Description")); runStatus.add(getCellContent("RunManager", i,
	 * "Execute")); invocationCount.add(getCellContent("RunManager", i,
	 * "InvocationCount")); priority.add(getCellContent("RunManager", i,
	 * "Priority")); } } catch(FileNotFoundException e) { e.printStackTrace(); }
	 * 
	 * }
	 */

}
