package com.Cucumber;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BaseClass.BaseClass;
import com.Pom.SDP;
import com.Property.ConfigurationHealper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {
	
	public SDP sdp;
	public String firstProductTitle;
	public String fPOP;
	public static WebDriver driver=CucumberRunnerClass.driver;
	public String searchProduct;
	
	
	@Given("user Launch The Browser and Application Url")
	public void user_launch_the_browser_and_application_url() throws IOException {
		browserLaunch("chrome");
		launchUrl("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@When("user Choose The Category From Dropdown")
	public void user_choose_the_category_from_dropdown() throws IOException {
		String SelectValue = "babY";
		
		sdp=new SDP(driver);

		List<WebElement> dropdownOptions = dropDownGetOptions(sdp.getHomePage().getdropDown());

		for (int i = 0; i < dropdownOptions.size(); i++) {

			WebElement eachoption = dropdownOptions.get(i);

			String eachText = getText(eachoption);

			if (eachText.equalsIgnoreCase(SelectValue)) {
				dropDownText(sdp.getHomePage().getdropDown(), eachText);
			}
		}

	}
	
	@When("user Search The Product In The Search Box and Choose The Relevant Product")
	public void user_search_the_product_in_the_search_box_and_choose_the_relevant_product() throws Throwable {
		
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
	}
	
	@Then("user Click The SearchButton and navigate to Search Product Page")
	public void user_click_the_search_button_and_navigate_to_search_product_page() throws Throwable {
		
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

	}
	
	@When("user Get The Title and Offer Price Of The First Product")
	public void user_get_the_title_and_offer_price_of_the_first_product() throws Throwable {
		
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

	}
	
	@Then("user Click On The First Product and Add The Product To The Cart and Click The Cart Icon")
	public void user_click_on_the_first_product_and_add_the_product_to_the_cart_and_click_the_cart_icon() throws Throwable {
		
		sdp.getSelectedProductPage().getaddToCart().click();
	}
	
	@When("user Verify The First Product Title and Offer Price In Cart Page")
	public void user_verify_the_first_product_title_and_offer_price_in_cart_page() throws InterruptedException {
		sdp.getCart().getcart().click();

		sleep();
	}
	
	@Then("user Click On Proceed To Buy and Navigate to SignIn Page")
	public void user_click_on_proceed_to_buy_and_navigate_to_sign_in_page() throws InterruptedException {
		sdp.getProceedToBuy().getproceedToBuy().click();

		sleep();
	}
	
	@When("user Take The Screenshot Of The SingIn Page")
	public void user_take_the_screenshot_of_the_sing_in_page() throws IOException {
		capture(driver);
	}
	
	@Then("user Close The Current Page and Quite The Browser")
	public void user_close_the_current_page_and_quite_the_browser() throws InterruptedException {
		close();

		sleep();
}
}

