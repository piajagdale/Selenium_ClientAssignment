package com.testng.assignment1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScrollingScript {
	//Url
		String scrollUrl = "http://openclinic.sourceforge.net/openclinic/home/index.php";
			
		WebDriver driver;	
		 
		 @BeforeClass
			public void setBaseURL(){
				System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe"); 
			    driver =new ChromeDriver();
			    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    driver.manage().window().maximize();
		 }
   		 @Test(priority = 4)
		 public void ScrollScript() {
			 driver.get(scrollUrl);
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,200)");
   		 }
   		 @AfterTest
   		 public void WebDriverClosure() {
   			driver.quit();
   		}
}
