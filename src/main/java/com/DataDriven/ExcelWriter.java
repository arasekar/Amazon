package com.DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
	
	public static void multipleData() throws IOException {
		
		File f=new File("C:\\Users\\aravi\\eclipse-workspace\\java\\AmazonNew\\src\\main\\java\\com\\DataDriven\\DataDriven.xlsx");
		
		FileInputStream fIP=new FileInputStream(f);
		
		Workbook w=new XSSFWorkbook(fIP);
		
		Sheet cs = w.createSheet("Amazon Write");
		
		Row cr = cs.createRow(0);
		
		Cell cc = cr.createCell(0);
		
		cc.setCellValue("Data");
		
		w.getSheet("Amazon Write").createRow(1).createCell(1).setCellValue("Driver");
		
		FileOutputStream fo=new FileOutputStream(f);
		
		w.write(fo);
		
		w.close();
	
	}
	
	public static void main(String[] args) throws IOException {
		
		multipleData();
	}

}
