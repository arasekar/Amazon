package com.Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProceedToBuy {

	public static WebDriver driver;
	
	//WebElement proceedToBuy = driver.findElement(By.xpath("//input[@value='Proceed to checkout']"));
	
	@FindBy(xpath="//input[@value='Proceed to checkout']")
	private WebElement proceedToBuy;
	
	public ProceedToBuy (WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
	}
	
	public WebElement getproceedToBuy() {
		return proceedToBuy;
	}
}
