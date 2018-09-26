package org.ets.selenium.tests.iviewer_selenium_regression_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * Hello world!
 *
 */
public class SetTear{
	protected WebDriver driver;
	
    @BeforeMethod
    @Parameters("browser")
    public void launchBrowser(String browser) {
    	if(browser.equalsIgnoreCase("Chrome")) {
    		System.setProperty("webdriver.chrome.driver", "/Users/mac/Desktop/apps/chromedriver/chromedriver");
    		 driver= new ChromeDriver();
    		 
    	}else if(browser.equalsIgnoreCase("FF")){
    		 driver= new FirefoxDriver();
    	}
    	driver.get("https://www.gmail.com");
    }

    @AfterMethod
	public void closeBrowser() {
    	driver.close();
    	driver.quit();
		
	}
    
    
}
