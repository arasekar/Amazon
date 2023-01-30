package com.BaseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver driver;
	
	public static void userInput(WebElement element,String Value) throws Throwable{
		try {
			boolean enabled = element.isEnabled();
			if(enabled==true) {
			element.sendKeys(Value);
			}
			else {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void cickOnElement(WebElement element) throws Throwable{
		try {
			boolean displayed = element.isDisplayed();
			if(displayed==true) {
			element.click();
			}
			else {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void clearText(WebElement element){
		element.clear();
	}
	
	public static String getText(WebElement element){
		String text = element.getText();
		System.out.println("The text is: "+text);
		return text;
	}
	
	public static void getAttributeValue(WebElement element, String value){
		String attribute = element.getAttribute(value);
		System.out.println(attribute);
	}
	
	public static void getAttributePlaceholder(WebElement element){
		String attribute = element.getAttribute("Placeholder");
		System.out.println(attribute);
	}
	
	public static void isSelected(WebElement element){
		boolean selected = element.isSelected();
		System.out.println(selected);
	}
	
	public static void isEnabled(WebElement element){
		boolean enabled = element.isEnabled();
		System.out.println(enabled);
	}
	
	public static void isDisplayed(WebElement element){
		boolean displayed = element.isDisplayed();
		System.out.println(displayed);
	}
	
	public static void sleep() throws InterruptedException{
		Thread.sleep(3000);
	}
	
	public static WebDriver browserLaunch(String browser){
		try {
			if(browser.equalsIgnoreCase("chrome")){
				ChromeOptions options=new ChromeOptions();
				options.addArguments("start-maximized");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
			}
else if(browser.equalsIgnoreCase("edge")){
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
else if(browser.equalsIgnoreCase("gecko")){
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
else if(browser.equalsIgnoreCase("internet explorer")){
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
else{
			System.out.println("It's a invalid browser");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	public static void maximize(){
		driver.manage().window().maximize();
	}
	public static void close() {
		driver.close();
	}
	public static void quit() {
		driver.quit();
	}
	public static void fullScreen() {
		driver.manage().window().fullscreen();
	}
	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}
	
	public static void navigateBack() {
		driver.navigate().back();
	}
	public static void navigateForward() {
		driver.navigate().forward();
	}
	public static void navigateRefresh() {
		driver.navigate().refresh();
	}
	
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	public static void launchUrl(String url) {
		driver.get(url);
	}
	
	
	public static String getWindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	
	public static Set<String> getMultileWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}
	
	public static void keyDown() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	
	public static void keyEnter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void keyUp() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}
	
	public static void acceptPrompt(String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	
	public static void alertSimple() {
		driver.switchTo().alert().accept();
		}
	public static void alertPrompt() {
		driver.switchTo().alert().dismiss();
	}
	
	public static void frameSwitch(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public static void defaultContent() {
		driver.switchTo().defaultContent();
	}
	
	public static void parentFrame() {
		driver.switchTo().parentFrame();
	}
	
	public static int totalFrame(List<WebElement> element) {
		int size = element.size();
		return size;
	
	}
	
	public static  void mouseBasedActions(String option,WebDriver driver,WebElement element) {
		Actions a = new Actions(driver);
		try {
			if(option.equalsIgnoreCase("move")) {
				a.moveToElement(element).build().perform();
			}else if(option.equalsIgnoreCase("click")) {
				a.click(element).perform();
			}else if(option.equalsIgnoreCase("Right Click")) {
				a.contextClick(element).build().perform();
			}else if(option.equalsIgnoreCase("Double Click")) {
				a.doubleClick(element).perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void dropDownValue(WebElement element,String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	public static void dropDownText(WebElement element,String value) {
		Select s = new Select(element);
		s.selectByVisibleText(value);
	}
	
	public static void dropDownIndex(WebElement element,String value) {
		Select s = new Select(element);
		int p = Integer.parseInt(value);
		s.selectByIndex(p);
	}
	
	public static List<WebElement> dropDownGetOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> dropdownOptions = s.getOptions();
		return dropdownOptions;
		
	}
	
	public static void dropDownGetAllSelected(WebElement element) {
		Select s = new Select(element);
		s.getAllSelectedOptions();
	}
	
	public static void dropDownGetFirstSelected(WebElement element) {
		Select s = new Select(element);
		s.getFirstSelectedOption();
	}
	
	public static void capture(WebDriver driver) throws IOException {
		Date date = new Date();
		//SimpleDateFormat d = new SimpleDateFormat("mm/dd/yyyy");
		SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String format = d.format(date).replaceAll("/", "-");
		System.out.println(format);
		
		TakesScreenshot shot=(TakesScreenshot)driver;
		File src = shot.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\aravi\\eclipse-workspace\\java\\AmazonNew\\src\\Screenshot\\Amazon" +format+ ".png");
		FileHandler.copy(src, dest);
	}
}
