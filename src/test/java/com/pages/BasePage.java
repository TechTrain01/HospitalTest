package com.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.PropertiesHandler;

public class BasePage {
	private static final Logger logger = LogManager.getLogger(BasePage.class);
	public static WebDriver driver;
	protected static WebDriverWait wait;
	
	
	public static WebDriver browserSetUp() {
		// Determine the browser type from properties and set up the WebDriver accordingly
		switch (PropertiesHandler.getProperty("browserType").toLowerCase()) {
		case "chrome":
			// Initialize ChromeDriver
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.manage().window().maximize();
			logger.info("Chrome browser setup completed.");
			break;
		case "edge":
			// Initialize EdgeDriver
			driver = new EdgeDriver();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.manage().window().maximize();
			logger.info("Edge browser setup completed.");
			break;
		default:
			// Initialize ChromeDriver as the default browser
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.manage().window().maximize();
			logger.info("Chrome (default) browser setup completed.");
			break;
		}

		// Navigate to the main page
		goToMainPage();

		return driver;
	}
	
	public static void goToMainPage() {
		try {
			// Wait for 2 seconds before navigating to the main page
			Thread.sleep(Duration.ofSeconds(2));
			// Get the base URL from properties
			String baseUrl = PropertiesHandler.getProperty("mainURI");
			// Navigate to the base URL
			driver.get(baseUrl);
			// Log the navigation to the main page
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void closeWeb() {
		if (driver != null) {
			// Quit the WebDriver instance
			driver.quit();
			// Log the successful closure of the browser
			logger.info("Browser closed successfully.");
		}
	}

}
