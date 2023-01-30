package com.Mini_Project.AmazonNew;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.BaseClass.BaseClass;
import com.Pom.SDP;

public class AmazonSDP extends BaseClass {

	public static void main(String[] args) throws Throwable {
		browserLaunch("chrome");
		launchUrl("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String SelectValue = "babY";
		
		SDP sdp=new SDP(driver);

		List<WebElement> dropdownOptions = dropDownGetOptions(sdp.getHomePage().getdropDown());

		for (int i = 0; i < dropdownOptions.size(); i++) {

			WebElement eachoption = dropdownOptions.get(i);

			String eachText = getText(eachoption);

			if (eachText.equalsIgnoreCase(SelectValue)) {
				dropDownText(sdp.getHomePage().getdropDown(), eachText);
			}
		}

		String searchProduct = "Soft Toys";

		userInput(sdp.getHomePage().getsearch(), searchProduct);

		sleep();

		System.out.println(sdp.getHomePage().getrelevant().size());

		for (int i = 1; i <= sdp.getHomePage().getrelevant().size(); i++) {

			String eachProductText = getText(sdp.getHomePage().geteachProduct());

			if (eachProductText.equalsIgnoreCase(searchProduct)) {
				cickOnElement(sdp.getHomePage().geteachProduct());
				break;
			}

		}
		sleep();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", sdp.getProductPage().getfirstproduct());

		String firstProductTitle = getText(sdp.getProductPage().getfirstproduct());

		System.out.println(firstProductTitle);

		String fPOP = getText(sdp.getProductPage().getfirstProductOffer());

		System.out.println(fPOP);

		sleep();

		cickOnElement(sdp.getProductPage().getfirstProductOffer());

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

		String selectedPText = getText(sdp.getSelectedProductPage().getselectedProductTitle());

		if (selectedPText.equalsIgnoreCase(firstProductTitle)) {
			System.out.println("Product title match");
		} else {
			System.out.println("Product title doesn't match");
		}

		String selectedPOPriceText = getText(sdp.getSelectedProductPage().getselectedProductOfferPrice());

		if (selectedPOPriceText.equalsIgnoreCase(fPOP)) {
			System.out.println("Product offer price match");
		} else {
			System.out.println("Product offer price doesn't match");
		}

		sdp.getSelectedProductPage().getaddToCart().click();

		sdp.getCart().getcart().click();

		sleep();

		sdp.getProceedToBuy().getproceedToBuy().click();

		sleep();

		capture(driver);

		close();

		sleep();

		quit();

	}

}
