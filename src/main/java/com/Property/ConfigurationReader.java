package com.Property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale.Category;
import java.util.Properties;

public class ConfigurationReader {
	
	public static Properties p;
	
	public ConfigurationReader() throws IOException {
	
	File f=new File("C:\\Users\\aravi\\eclipse-workspace\\java\\AmazonNew\\src\\main\\java\\com\\Property\\Amazon.properties");
	
	FileInputStream fp=new FileInputStream(f);
	
	p = new Properties();
	
	p.load(fp);
	
	}
	
	public static String getbrowser() {
		String browser = p.getProperty("browser");
		return browser;
	}
	
	public static String geturl() {
		String url = p.getProperty("url");
		return url;
	}
	
	public static String getcategory() {
		String category = p.getProperty("category");
		return category;
	}
	
	public static String getproduct() {
		String product = p.getProperty("product");
		return product;
	}
	
	public static String getsheet() {
		String sheet = p.getProperty("sheet");
		return sheet;
	}
	
	public static String getsheetpath() {
		String sheetpath = p.getProperty("sheetPath");
		return sheetpath;
	}
}
