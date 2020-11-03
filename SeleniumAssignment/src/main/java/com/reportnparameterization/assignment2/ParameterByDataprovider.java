package com.reportnparameterization.assignment2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterByDataprovider {
	static WebDriver driver;
	String driverExe = "D:\\chromedriver_win32\\chromedriver.exe";
    @BeforeTest
    public void setup(){
    	
         System.setProperty("webdriver.chrome.driver",driverExe );
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         driver.get("https://google.com");
    } 

    @Test(dataProvider="SearchProvider")
    public void testMethod(String author,String searchKey) throws InterruptedException{
    	{
	        WebElement searchText = driver.findElement(By.name("q"));
	        //search value in google searchbox
	        searchText.sendKeys(searchKey);
	        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
	        Thread.sleep(3000);
	        String testValue = searchText.getAttribute("value");
	        System.out.println(testValue +"::::"+searchKey);
	        searchText.clear();
	        //Verify if the value in google search box is correct
	        Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
	    }
    }

    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { 
            	"Supriya", "Selenium questions" 
            },
            { 
            	"Mahesh", "BDD Framework" 
            },
            { 
            	"Jagdale", "Functional testing" 
            }
        };

    }
    @AfterTest
	public void WebDriverClosure() {
		driver.quit();
	}
}
