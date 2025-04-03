package com.hospital.practo.hooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.pages.BasePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks{
	private static final Logger logger = LogManager.getLogger(Hooks.class);

	@After
	public void tearDown(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "Screenshot"); 
		
		BasePage.closeWeb();
		logger.info("@AFTER: Webpage closed");
	}
}
