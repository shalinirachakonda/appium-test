package org.ets.selenium.tests.iviewer_selenium_regression_tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Links{
	
	private WebDriver driver;
	
	public Links(WebDriver driver) {
		this.driver= driver;
		
	}
	
	public List<String> getLinkTexts() {
		List<String> list= new ArrayList<String>();
		java.util.List<WebElement> linkElements= driver.findElements(By.tagName("a"));
		for(WebElement element:linkElements) {
			list.add(element.getText());
		}
		return list;
	}
	
	public Map<String, String> getLinkTextAndTitle(){
		Map<String, String> mp= new HashMap<String, String>();
		mp.put("Buy", "Zillow:real estate");
		mp.put("Sell", "Sell your Home");
		
		return mp;
	}
	
	

}
