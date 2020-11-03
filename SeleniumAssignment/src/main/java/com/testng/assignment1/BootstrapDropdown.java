package com.testng.assignment1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BootstrapDropdown {
		
		//Url
		String bootstrapDropdownUrl = "https://www.jquery-az.com/boots/demo.php?ex=63.0_2";
				
		WebDriver driver;	
		 
		@BeforeClass
		public void setBaseURL(){
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe"); 
			driver =new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			   
			}
		 	@Test
		 	public void BootstrapDropdownmethod() {
		 		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 		driver.get(bootstrapDropdownUrl);
		 		driver.findElement(By.xpath("//*[@type='button']")).click();
		 		
		 		List<WebElement> listdrop=  driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li//a//label"));
		 		System.out.println(listdrop.size());
				
				 for(int i =0; i<listdrop.size(); i++) {
				 System.out.println(listdrop.get(i).getText()); if
				 (listdrop.get(i).getText().contains("Angular")) { listdrop.get(i).click();
				 //element will be find then break the loop 
				 break; } 
			}
				 
		 }
		 @AfterTest
			public void WebDriverClosure() {
				driver.quit();
		}
}
