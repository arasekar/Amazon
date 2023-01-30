package com.Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {

	public static WebDriver driver;
	
	//WebElement cart = driver.findElement(By.xpath("//div[@id='nav-tools']//a[@id='nav-cart']"));
	@FindBy(xpath="//div[@id='nav-tools']//a[@id='nav-cart']")
	private WebElement cart;
	
	public Cart (WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
	}
	
	public WebElement getcart() {
		return cart;
	}
}
