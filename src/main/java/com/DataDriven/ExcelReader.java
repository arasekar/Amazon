package com.DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Property.ConfigurationHealper;

public class ExcelReader {
	
	public static String value;
	
		public static String singleData(String sheetName, int row, int cell) throws IOException {
			
			String sheetpath = ConfigurationHealper.getInstance().getsheetpath();
			
			//File f=new File("C:\\Users\\aravi\\eclipse-workspace\\java\\AmazonNew\\src\\main\\java\\com\\DataDriven\\DataDriven.xlsx");
			File f=new File(sheetpath);
			FileInputStream fIP=new FileInputStream(f);
			
			Workbook w=new XSSFWorkbook(fIP);
			
			Sheet s = w.getSheet(sheetName);
			
			Row r = s.getRow(row);
			
			Cell c = r.getCell(cell);
			
			CellType ct = c.getCellType();
			
			if(ct.equals(CellType.STRING)) {
				System.out.println(c.getStringCellValue());
				value = c.getStringCellValue();
			}
			else if(ct.equals(CellType.NUMERIC)){
				System.out.println(c.getNumericCellValue());
				double dValue = c.getNumericCellValue();
				int a=(int) dValue;
				value = String.valueOf(a);
			}
				return value;
		}
		
		
}	

