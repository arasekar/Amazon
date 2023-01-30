package com.Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	public static WebDriver driver;
	
	//WebElement firstproduct = driver.findElement(By.xpath("//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//h2"));
	
	@FindBy(xpath="//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//h2")
	private WebElement firstproduct;
	
	//WebElement firstProductOffer = driver.findElement(By.xpath("//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//span[@class='a-price']"));
	
	@FindBy(xpath="//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//span[@class='a-price']")
	private WebElement firstProductOffer;
	
	public ProductPage (WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
	}
	
	public WebElement getfirstproduct() {
		return firstproduct;
	}
	public WebElement getfirstProductOffer() {
		return firstProductOffer;
	}
	
}
