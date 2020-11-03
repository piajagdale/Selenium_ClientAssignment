package com.testng.assignment1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WithoutSenkeys {
	String dragdropUrl = "https://jqueryui.com/droppable/";
	
	WebDriver driver;	
	 
	 @BeforeClass
		public void setBaseURL(){
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe"); 
		    driver =new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.manage().window().maximize(); 
	 }
	 @Test(priority = 6)
	    public void WithoutSenkeysM() {
	    	driver.get(dragdropUrl);
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	WebElement search = driver.findElement(By.xpath("//input[@class='ds-input']"));
	    	
			js.executeScript("arguments[0].value = 'droppable'" , search);
	    }
	 @AfterTest
		public void WebDriverClosure() {
			driver.quit();
		}
}
