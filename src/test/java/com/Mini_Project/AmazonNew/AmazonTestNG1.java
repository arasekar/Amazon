package com.Mini_Project.AmazonNew;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTestNG1 
	{
	WebDriver driver=null;
	String firstProductTitle = null;
	String fPOP = null;

@BeforeTest
private void browserLaunch() 
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver(options);
	}

@BeforeClass
private void urlLaunch() 
	{
		driver.get("https://www.amazon.in/");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

@Test(priority = -3)
private void dropDown() 
	{
		String SelectValue = "babY";
		WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
		Select s = new Select(dropDown);
		List<WebElement> dropdownOptions = s.getOptions();
		for (int i = 0; i < dropdownOptions.size(); i++) {
		WebElement eachoption = dropdownOptions.get(i);
	    String eachText = eachoption.getText();
	    if (eachText.equalsIgnoreCase(SelectValue)) {
	    s.selectByVisibleText(eachText);
      }
     }
	}

@Test(priority = -2)
private void productInput() throws InterruptedException 
	{
		String searchProduct = "Soft Toys";
	    WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
	    search.sendKeys(searchProduct);
	    Thread.sleep(2000);
	    List<WebElement> relevant = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']/child::div"));
	    System.out.println(relevant.size());
	    for (int i = 1; i <= relevant.size(); i++) {
	    WebElement eachProduct = driver.findElement(By.xpath("//div[@class='autocomplete-results-container']/child::div[" + i + "]/div/div[@role='button']"));
	    String eachProductText = eachProduct.getText();
	    if (eachProductText.equalsIgnoreCase(searchProduct)) {
	    eachProduct.click();
	    break;
      }
	 }
	}

@Test(priority = -1)
private void firstProductNamePrice() throws InterruptedException 
	{
		WebElement firstproduct = driver.findElement(By.xpath("//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//h2"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", firstproduct);
	    firstProductTitle = firstproduct.getText();
	    System.out.println(firstProductTitle);
	    WebElement firstProductOffer = driver.findElement(By.xpath("//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//span[@class='a-price']"));
	    fPOP = firstProductOffer.getText();
	    System.out.println(fPOP);
	    Thread.sleep(3000);
	    firstProductOffer.click();
	}

@Test(priority = 0)
private void windowsTitle() throws InterruptedException 
	{
	String parentId = driver.getWindowHandle();		  
    Thread.sleep(3000);
    String Currenttitle = driver.getTitle();
    System.out.println(Currenttitle);
    Set<String> allId = driver.getWindowHandles();
    System.out.println(allId.size());
    for (String id : allId) {
      if (!(id.equals(parentId))) {
        driver.switchTo().window(id);
      }
    }
    Thread.sleep(1000);
    }

@Test(priority = 1)
private void compareTitlePrice() {
		
		WebElement selectedProductTitle = driver.findElement(By.xpath("//div[@id='titleSection']/child::h1/child::span"));
	    String selectedPText = selectedProductTitle.getText();
		if(selectedPText.equalsIgnoreCase(firstProductTitle)) {
	      System.out.println("Product title match");
	    }else {
	      System.out.println("Product title doesn't match");
	    }
	    WebElement selectedProductOfferPrice = driver.findElement(By.xpath("//div[@id='title_feature_div']/following-sibling::div[9]/child::div[3]/child::div[1]/span[2]"));
	    String selectedPOPriceText = selectedProductOfferPrice.getText();
	    if(selectedPOPriceText.equalsIgnoreCase(fPOP)) {
	      System.out.println("Product offer price match");
	    }else {
	      System.out.println("Product offer price doesn't match");
	    }
	    }

@Ignore
private void proceedCheckOut() throws InterruptedException
		{
		driver.findElement(By.id("add-to-cart-button")).click();
	    driver.findElement(By.xpath("//div[@id='nav-tools']//a[@id='nav-cart']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@value='Proceed to checkout']")).click();
	    Thread.sleep(2000);
		}
	    
@Test(priority = 3)
private void screenShot() throws IOException
		{	    
	    TakesScreenshot shot=(TakesScreenshot)driver;
		File src = shot.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\aravi\\eclipse-workspace\\java\\AmazonNew\\src\\Screenshot\\testNGscreen.png");
		FileHandler.copy(src, dest);
		}

@AfterTest
private void closeQuit() throws InterruptedException
		{
	    driver.close();
	    Thread.sleep(2000);
	    driver.quit();
		}

}

