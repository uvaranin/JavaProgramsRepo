package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.record.aggregates.WorksheetProtectionBlock;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static String testDataSheetPath = "C:\\Users\\uvana\\Downloads\\FreeCRMTest-20211030T160420Z-001\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRM_testdata.xlsx";
	
	public void switchToFrame(String name) {
		driver.switchTo().frame(name);
	}
	
	public static Object[][] getTestData(String testDataSheetPath) throws EncryptedDocumentException, IOException{
		//String sheetName = "C:\\Users\\uvana\\Downloads\\FreeCRMTest-20211030T160420Z-001\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRM_testdata.xlsx";
		FileInputStream fileInputStream = new FileInputStream(new File(testDataSheetPath));
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i = 0; i<=sheet.getLastRowNum()-1; i++) {
			for(int j = 0; j<=sheet.getRow(i).getLastCellNum()-1; j++) {
				//System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	
	public static void takeScreenshot() {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		System.out.println(currentDir);
		try {
			FileUtils.copyFile(sourceFile, new File(currentDir + "\\screenshots\\"+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
