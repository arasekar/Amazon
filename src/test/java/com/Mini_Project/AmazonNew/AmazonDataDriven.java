package com.Mini_Project.AmazonNew;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

import com.DataDriven.ExcelReader;
import com.Property.ConfigurationHealper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonDataDriven {
	
private static List<String> desiredOptions() {
		
		List<String>listOfOptions=new ArrayList<String>();
		listOfOptions.add("start-maximized");
		listOfOptions.add("incognito");
		return listOfOptions;
	}
	public static void main(String[] args) throws InterruptedException, IOException {
			ChromeOptions options=new ChromeOptions();
			options.addArguments(desiredOptions());
		    WebDriverManager.chromedriver().setup();
		    WebDriver driver = new ChromeDriver(options);
		    driver.get("https://www.amazon.in/");
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    String sheet = ConfigurationHealper.getInstance().getsheet();
		    String bab = ExcelReader.singleData(sheet, 0, 0);
		    String SelectValue = bab;

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
		    
		    String soto = ExcelReader.singleData(sheet, 1, 1);
		    String searchProduct = soto;

		    WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		    search.sendKeys(searchProduct);

		    Thread.sleep(2000);

		    List<WebElement> relevant = driver
		        .findElements(By.xpath("//div[@class='autocomplete-results-container']/child::div"));
		    System.out.println(relevant.size());

		    for (int i = 1; i <= relevant.size(); i++) {

		      WebElement eachProduct = driver.findElement(By.xpath(
		          "//div[@class='autocomplete-results-container']/child::div[" + i + "]/div/div[@role='button']"));

		      String eachProductText = eachProduct.getText();

		      if (eachProductText.equalsIgnoreCase(searchProduct)) {
		        eachProduct.click();
		        break;
		      }

		    }
		    Thread.sleep(3000);

		    WebElement firstproduct = driver
		        .findElement(By.xpath("//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//h2"));

		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView(true);", firstproduct);

		    String firstProductTitle = firstproduct.getText();

		    System.out.println(firstProductTitle);

		    WebElement firstProductOffer = driver.findElement(By
		        .xpath("//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//span[@class='a-price']"));

		    String fPOP = firstProductOffer.getText();

		    System.out.println(fPOP);
		    
		    Thread.sleep(3000);
		    
		    firstProductOffer.click();
		    
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

		    driver.findElement(By.id("add-to-cart-button")).click();
		    
		    driver.findElement(By.xpath("//div[@id='nav-tools']//a[@id='nav-cart']")).click();
		    
		    Thread.sleep(2000);
		    
		    
		    driver.findElement(By.xpath("//input[@value='Proceed to checkout']")).click();
		    
		    Thread.sleep(2000);
		    
		    TakesScreenshot shot=(TakesScreenshot)driver;
			File src = shot.getScreenshotAs(OutputType.FILE);
			File dest=new File("C:\\Users\\aravi\\eclipse-workspace\\java\\AmazonNew\\src\\Screenshot\\screen.png");
			FileHandler.copy(src, dest);
		    
		    driver.close();
		    
		    
		    Thread.sleep(4000);
		    
		    
		    driver.quit();
		    
	}
		
}
	    
		



