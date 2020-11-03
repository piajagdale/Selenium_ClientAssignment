package com.testng.assignment1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReadProperty {
	
			public static WebDriver driver; 

			@BeforeClass
			public void setUp() {
				System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}
			
			@Test
			public void signIn() throws IOException {
				
				Properties property=new Properties();
				
				FileInputStream fis=new FileInputStream("C:\\Users\\Priya\\git\\Selenium_ClientAssignment\\HSBCProject\\src\\main\\resources\\Properties");
				
				property.load(fis);
				
				driver.get(property.getProperty("baseURL"));
				driver.findElement(By.xpath(property.getProperty("signIn"))).click();
				driver.findElement(By.cssSelector(property.getProperty("userName"))).sendKeys("piajagdale@gmail.com");
				driver.findElement(By.cssSelector(property.getProperty("next"))).click();
				driver.findElement(By.cssSelector(property.getProperty("password"))).sendKeys("Priya#123");
				driver.findElement(By.cssSelector(property.getProperty("signInSubmit"))).click();
			}
		
}


