package org.ets.selenium.tests.iviewer_selenium_regression_tests;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import junit.framework.AssertionFailedError;

@Test
public class TestLinks extends SetTear {

	public void verifyAllLinksWorks() {
		
		Links lks= new Links(driver);
		//List<String> linkText= lks.getLinkTexts();
		Map<String, String> mapLinkTitle= lks.getLinkTextAndTitle();
		//for(String text:linkText) {
		for(String key: mapLinkTitle.keySet()) {
			driver.findElement(By.linkText(key)).click();
			String bodyText= driver.findElement(By.tagName("body")).getText();
			try {
				Assert.assertTrue(bodyText.contains("404 error"), key+" is a broken link");
				Assert.assertEquals(driver.getTitle(), mapLinkTitle.get(key));
			} catch (AssertionError e) {
				Reporter.log(key+" is a broken link"+e.getMessage());
				
			}
			driver.get("https://www.zillow.com");
		}
		
		
		
	}
}
