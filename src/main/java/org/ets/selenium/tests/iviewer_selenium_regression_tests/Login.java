package org.ets.selenium.tests.iviewer_selenium_regression_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login{
	private WebDriver driver;
	
	public Login(WebDriver driver) {
		this.driver= driver;
	}
	
	public void loginToApp() {
		driver.findElement(By.id("identifierId")).sendKeys("shalinichalluri@gmail.com");
		driver.findElement(By.className("CwaK9")).click();
		//driver.findElement(By.className("wpW1cb")).click();
		driver.findElement(By.name("password")).sendKeys("Saanvi123");
		driver.findElement(By.className("CwaK9")).click();
	}
	
}