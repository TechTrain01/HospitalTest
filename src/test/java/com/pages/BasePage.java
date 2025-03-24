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
		switch (PropertiesHandler.getProperty("browserType").toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.manage().window().maximize();
			logger.info("Chrome browser setup completed.");
			break;
		case "edge":
			driver = new EdgeDriver();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.manage().window().maximize();
			logger.info("Edge browser setup completed.");
			break;
		default:
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.manage().window().maximize();
			logger.info("Chrome (default) browser setup completed.");
			break;
		}

		goToMainPage();

		return driver;
	}
	
	public static void goToMainPage() {
		try {
			Thread.sleep(Duration.ofSeconds(2));
			String baseUrl = PropertiesHandler.getProperty("mainURI");
			driver.get(baseUrl);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void closeWeb() {
		if (driver != null) {
			driver.quit();
			logger.info("Browser closed successfully.");
		}
	}

}
