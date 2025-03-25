package com.utils;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;


public class PageActions {
	
	private static final Logger logger = LogManager.getLogger(PageActions.class);
	static FluentWait<WebDriver> wait1;
	
	public PageActions(WebDriver driver) {
	    PageActions.wait1 = new FluentWait<>(driver)
	        .withTimeout(Duration.ofSeconds(30))
	        .pollingEvery(Duration.ofSeconds(5))
	        .ignoring(NoSuchElementException.class);
	}
	
	public static boolean isElementDisplayed(WebElement element) {
		logger.info("Checking if element is displayed: " + element);
		waitFor(element);
		boolean isDisplayed = element.isDisplayed();
        logger.info("Element displayed: " + isDisplayed);
        return isDisplayed;
	}
	
	
	public void clickElement(WebElement element) {
		element.click();
	}
	
	
	public void enterText(WebElement element, String text) {
		element.clear();
	    element.sendKeys(text);
	    logger.info("Entering text '" + text + "' into element: " + element);
	}
	
	public static void waitFor(WebElement element) {
		wait1.until(driver -> element.isDisplayed());
		logger.info("Waits for element " + element + " to be displayed");
	}
	
	public void selectFromDropdown(WebElement dropdown, String value) {
	    Select select = new Select(dropdown);
	    select.selectByVisibleText(value);
	    logger.info("Selecting value '" + value + "' from dropdown: " + dropdown);
	}
	
	public void acceptAlert(WebDriver driver) {
	    logger.info("Accepting alert");
	    driver.switchTo().alert().accept();
	}

	public void dismissAlert(WebDriver driver) {
	    logger.info("Dismissing alert");
	    driver.switchTo().alert().dismiss();
	}
	
	

}
