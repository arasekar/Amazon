package com.Mini_Project.AmazonNew;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.BaseClass.BaseClass;
import com.Pom.Cart;
import com.Pom.HomePage;
import com.Pom.ProceedToBuy;
import com.Pom.ProductPage;
import com.Pom.SelectedProductPage;

public class AmazonPOM extends BaseClass {

	public static void main(String[] args) throws Throwable {
		browserLaunch("chrome");
		launchUrl("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String SelectValue = "babY";

		HomePage hp = new HomePage(driver);
		ProductPage pp = new ProductPage(driver);
		SelectedProductPage spp = new SelectedProductPage(driver);
		Cart c = new Cart(driver);
		ProceedToBuy ptb = new ProceedToBuy(driver);

		List<WebElement> dropdownOptions = dropDownGetOptions(hp.getdropDown());

		for (int i = 0; i < dropdownOptions.size(); i++) {

			WebElement eachoption = dropdownOptions.get(i);

			String eachText = getText(eachoption);

			if (eachText.equalsIgnoreCase(SelectValue)) {
				dropDownText(hp.getdropDown(), eachText);
			}
		}

		String searchProduct = "Soft Toys";

		userInput(hp.getsearch(), searchProduct);

		sleep();

		System.out.println(hp.getrelevant().size());

		for (int i = 1; i <= hp.getrelevant().size(); i++) {

			String eachProductText = getText(hp.geteachProduct());

			if (eachProductText.equalsIgnoreCase(searchProduct)) {
				cickOnElement(hp.geteachProduct());
				break;
			}

		}
		sleep();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", pp.getfirstproduct());

		String firstProductTitle = getText(pp.getfirstproduct());

		System.out.println(firstProductTitle);

		String fPOP = getText(pp.getfirstProductOffer());

		System.out.println(fPOP);

		sleep();

		cickOnElement(pp.getfirstProductOffer());

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

		String selectedPText = getText(spp.getselectedProductTitle());

		if (selectedPText.equalsIgnoreCase(firstProductTitle)) {
			System.out.println("Product title match");
		} else {
			System.out.println("Product title doesn't match");
		}

		String selectedPOPriceText = getText(spp.getselectedProductOfferPrice());

		if (selectedPOPriceText.equalsIgnoreCase(fPOP)) {
			System.out.println("Product offer price match");
		} else {
			System.out.println("Product offer price doesn't match");
		}

		spp.getaddToCart().click();

		c.getcart().click();

		sleep();

		ptb.getproceedToBuy().click();

		sleep();

		capture(driver);

		close();

		sleep();

		quit();

	}

}
