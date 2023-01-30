package com.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SDP {
	
		public static WebDriver driver;
		
		private HomePage hp;
		private ProductPage pp;
		private SelectedProductPage spp;
		private Cart c;
		private ProceedToBuy ptb;
		
		public SDP(WebDriver driver2) {
			this.driver=driver2;
			PageFactory.initElements(driver, this);
		}
		
		public HomePage getHomePage() {
			if(hp==null) {
			hp=new HomePage(driver);
			}
			return hp;
		}
		public ProductPage getProductPage() {
			if(pp==null) {
			pp=new ProductPage(driver);
			}
			return pp;
		}
		public SelectedProductPage getSelectedProductPage() {
			if(spp==null) {
			spp=new SelectedProductPage(driver);
			}
			return spp;
		}
		public Cart getCart() {
			if(c==null) {
			c=new Cart(driver);
			}
			return c;
		}
		public ProceedToBuy getProceedToBuy() {
			if(ptb==null) {
			ptb=new ProceedToBuy(driver);
			}
			return ptb;
		}

}

