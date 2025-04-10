package com.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.PropertiesHandler;

public class BasePage {
	private static final Logger logger = LogManager.getLogger(BasePage.class);
	public static WebDriver driver;
	protected static WebDriverWait wait;

	public static WebDriver browserSetUp() {
		boolean isHeadless = Boolean.parseBoolean(PropertiesHandler.getProperty("headless"));

		switch (PropertiesHandler.getProperty("browserType").toLowerCase()) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			if (isHeadless) {
				chromeOptions.addArguments("--headless");
			}
			driver = new ChromeDriver(chromeOptions);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.manage().window().maximize();
			logger.info("Chrome browser setup completed.");
			break;
		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
			if (isHeadless) {
				edgeOptions.addArguments("--headless");
			}
			driver = new EdgeDriver(edgeOptions);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.manage().window().maximize();
			logger.info("Edge browser setup completed.");
			break;
		default:
			ChromeOptions defaultOptions = new ChromeOptions();
			if (isHeadless) {
				defaultOptions.addArguments("--headless");
			}
			driver = new ChromeDriver(defaultOptions);
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
			logger.info("Navigated to the main page.");
		} catch (Exception ex) {
			logger.error("Error navigating to the main page: " + ex.getMessage());
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
