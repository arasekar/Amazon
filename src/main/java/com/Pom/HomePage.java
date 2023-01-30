package com.Pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public static WebDriver driver;
		
		//WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
		@FindBy(id="searchDropdownBox")
		private WebElement dropDown;
		
		//WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		@FindBy(id="twotabsearchtextbox")
		private WebElement search;
		
		//List<WebElement> relevant = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']/child::div"));
		@FindBy(xpath="//div[@class='autocomplete-results-container']/child::div")
		private List<WebElement> relevant;
		
		//WebElement eachProduct = driver.findElement(By.xpath("//div[@class='autocomplete-results-container']/child::div[" + i + "]/div/div[@role='button']"));
		@FindBy(xpath="//div[@class='autocomplete-results-container']/child::div[\" + i + \"]/div/div[@role='button']")
		private WebElement eachProduct;
		
		public HomePage (WebDriver driver2) {
			this.driver=driver2;
			PageFactory.initElements(driver2, this);
		}
		
		public WebElement getdropDown() {
			return dropDown;
		}
		public WebElement getsearch() {
			return search;
		}
		public List<WebElement> getrelevant() {
			return relevant;
		}
		public WebElement geteachProduct() {
			return eachProduct;
		}
	}
		

