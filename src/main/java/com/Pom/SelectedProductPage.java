package com.Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectedProductPage {
	
	public static WebDriver driver;
	
	//WebElement selectedProductTitle = driver.findElement(By.xpath("//div[@id='titleSection']/child::h1/child::span"));
	
	@FindBy(xpath="//div[@id='titleSection']/child::h1/child::span")
	private WebElement selectedProductTitle;
	
	//WebElement selectedProductOfferPrice = driver.findElement(By.xpath("//div[@id='title_feature_div']/following-sibling::div[9]/child::div[3]/child::div[1]/span[2]"));
	
	@FindBy(xpath="//div[@id='title_feature_div']/following-sibling::div[9]/child::div[3]/child::div[1]/span[2]")
	private WebElement selectedProductOfferPrice;
	
	//WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
	@FindBy(id="add-to-cart-button")
	private WebElement addToCart;
	
	public SelectedProductPage (WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
	}

	public WebElement getselectedProductTitle() {
		return selectedProductTitle;
	}
	public WebElement getselectedProductOfferPrice() {
		return selectedProductOfferPrice;
	}
	public WebElement getaddToCart() {
		return addToCart;
	}
}
