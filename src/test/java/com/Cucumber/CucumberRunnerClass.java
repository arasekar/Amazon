package com.Cucumber;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.BaseClass.BaseClass;
import com.Property.ConfigurationHealper;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\java\\com\\Cucumber\\Amazon.feature", glue="StepDefinition")
public class CucumberRunnerClass {
	
	public static WebDriver driver=null;
	
	@BeforeClass
	public static void browserLaunch() throws IOException {
		
		String browser = ConfigurationHealper.getInstance().getbrowser();
		driver = BaseClass.browserLaunch(browser);
	}
	
	@AfterClass
	public static void browserClose() {
		BaseClass.close();
	}

}
