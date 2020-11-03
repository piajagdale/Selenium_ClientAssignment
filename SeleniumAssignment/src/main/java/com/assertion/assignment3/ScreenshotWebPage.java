package com.assertion.assignment3;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenshotWebPage {
	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://api.jquery.com/dblclick/");
	}

	@Test
	public void CaptureScreenShot() {
		AShot ashot = new AShot();

		BufferedImage image = ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver)
				.getImage();
		try {
			ImageIO.write(image, "JPG", new File("D:\\Supriya\\Jquery.ScreenShot.JPG"));

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	@AfterClass
	public void WebDriverClosure() {
		driver.quit();
	}
}
