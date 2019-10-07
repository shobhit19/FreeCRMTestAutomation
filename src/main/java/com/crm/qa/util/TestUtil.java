package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.testbase.TestBase;

public class TestUtil extends TestBase{

	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	public void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}
	
	public static String testSheetPath="C:\\Users\\Mudit\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMContactsTestData.xlsx";
	
	// To get test data
	public static  Object[][] getTestData(String sheetName){
		FileInputStream file=null;
		try {
			file = new FileInputStream(testSheetPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet=book.getSheet(sheetName);
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
				
			}
		}
		
		return data;
	}
	
	public  static void takeScreenshotAtEndOfTest() throws IOException{
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
		FileUtils.copyFile(srcFile,new File(currentDir+"/screenshots"+System.currentTimeMillis()+".png"));
		
	}
	
	
}