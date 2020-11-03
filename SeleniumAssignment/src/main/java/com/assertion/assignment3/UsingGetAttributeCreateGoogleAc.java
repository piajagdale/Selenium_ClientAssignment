package com.assertion.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UsingGetAttributeCreateGoogleAc {
	static WebDriver driver;
	By acountFirstName = By.id("firstName");
	By acountLastName = By.id("lastName");
	By userName = By.id("username");
	By password = By.name("Passwd");
	By confirmPassword = By.name("ConfirmPasswd");
	

	@BeforeClass
	public void setBaseURL() {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/signup");
	}
	
		@Test
		public void FirstName() {
			
			WebElement fName = driver.findElement(acountFirstName);
			System.out.println("Id of the button is:- " +fName.getAttribute("id"));
			
		}

		@Test
		public void LastName() {
			WebElement lName = driver.findElement(acountLastName);
			System.out.println("Id of the button is:- "+ lName.getAttribute("id"));
		}

		@Test
		public void UserName() {

			WebElement email = driver.findElement(userName);
			System.out.println("Class of the button is:- "+ email.getAttribute("id"));

		}
		@Test
		public void Password() {

			WebElement ePassword = driver.findElement(password);
			System.out.println("Class of the button is:- "+ ePassword.getAttribute("class"));

		}
		@Test
		public void ConfirmPassword() {

			WebElement eConfirmPassword = driver.findElement(confirmPassword);
			System.out.println("Class of the button is:- "+ eConfirmPassword.getAttribute("name"));

		}

	@AfterClass
	public void WebDriverClosure() {
		driver.quit();
	}
}
