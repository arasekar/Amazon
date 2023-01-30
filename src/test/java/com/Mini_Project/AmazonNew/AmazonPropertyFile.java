package com.Mini_Project.AmazonNew;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.BaseClass.BaseClass;
import com.Property.ConfigurationHealper;

public class AmazonPropertyFile extends BaseClass {
	
	//public static WebDriver driver;

	public static void main(String[] args) throws Throwable {
			String browser = ConfigurationHealper.getInstance().getbrowser();
			browserLaunch(browser);
			
			String url = ConfigurationHealper.getInstance().geturl();
			launchUrl(url);
		    
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    
		    String category = ConfigurationHealper.getInstance().getcategory();
		    String SelectValue = category;
		    
		    WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
		    
		    List<WebElement> dropdownOptions= dropDownGetOptions(dropDown);

		    for (int i = 0; i < dropdownOptions.size(); i++) {

		      WebElement eachoption = dropdownOptions.get(i);

		      String eachText = getText(eachoption);

		      if (eachText.equalsIgnoreCase(SelectValue)) {
		        dropDownText(dropDown,eachText);
		      }
		    }
		    
		    String product = ConfigurationHealper.getInstance().getproduct();
		    String searchProduct = product;

		    WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		    userInput(search, searchProduct);

		    sleep();

		    List<WebElement> relevant = driver
		        .findElements(By.xpath("//div[@class='autocomplete-results-container']/child::div"));
		    System.out.println(relevant.size());

		    for (int i = 1; i <= relevant.size(); i++) {

		      WebElement eachProduct = driver.findElement(By.xpath(
		          "//div[@class='autocomplete-results-container']/child::div[" + i + "]/div/div[@role='button']"));

		      String eachProductText = getText(eachProduct);

		      if (eachProductText.equalsIgnoreCase(searchProduct)) {
		    	  cickOnElement(eachProduct);
		        break;
		      }

		    }
		    sleep();

		    WebElement firstproduct = driver
		        .findElement(By.xpath("//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//h2"));

		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView(true);", firstproduct);

		    String firstProductTitle = getText(firstproduct);

		    System.out.println(firstProductTitle);

		    WebElement firstProductOffer = driver.findElement(By
		        .xpath("//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//span[@class='a-price']"));

		    String fPOP = getText(firstProductOffer);

		    System.out.println(fPOP);
		    
		    sleep();
		    
		    cickOnElement(firstProductOffer);
		    
		    String parentId = getWindow();		  
		    
		    sleep();

		    String Currenttitle = getTitle();

		    System.out.println(Currenttitle);

		    Set<String> allId = getMultileWindow();

		    System.out.println(allId.size());

		    for (String id : allId) {

		      if (!(id.equals(parentId))) {
		        driver.switchTo().window(id);
		      }

		    }
		    
		    sleep();
		    
		    WebElement selectedProductTitle = driver.findElement(By.xpath("//div[@id='titleSection']/child::h1/child::span"));
		    
		    String selectedPText = getText(selectedProductTitle);
		    
		    if(selectedPText.equalsIgnoreCase(firstProductTitle)) {
		      System.out.println("Product title match");
		    }else {
		      System.out.println("Product title doesn't match");
		    }
		    
		    WebElement selectedProductOfferPrice = driver.findElement(By.xpath("//div[@id='title_feature_div']/following-sibling::div[9]/child::div[3]/child::div[1]/span[2]"));
		    
		    
		    String selectedPOPriceText = getText(selectedProductOfferPrice);

		    if(selectedPOPriceText.equalsIgnoreCase(fPOP)) {
		      System.out.println("Product offer price match");
		    }else {
		      System.out.println("Product offer price doesn't match");
		    }

		    WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
		    addToCart.click();
		    
		    WebElement cart = driver.findElement(By.xpath("//div[@id='nav-tools']//a[@id='nav-cart']"));
		    cart.click();
		    
		    sleep();
		    
		    
		    WebElement proceedToBuy = driver.findElement(By.xpath("//input[@value='Proceed to checkout']"));
		    proceedToBuy.click();
		    
		    sleep();
		    
		    capture(driver);
		    
		    close();
		    
		    sleep();
		    
		    quit();
		    
	}
		
}
	    
		



