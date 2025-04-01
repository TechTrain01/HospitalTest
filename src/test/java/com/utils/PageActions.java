package com.utils;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class PageActions {

	private static final Logger logger = LogManager.getLogger(PageActions.class);
	static FluentWait<WebDriver> wait1;
	private WebDriver driver;

	public PageActions(WebDriver driver) {
		this.driver = driver;
		PageActions.wait1 = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
	}

	public boolean isElementDisplayed(WebElement element) {
		logger.info("Checking if element is displayed: " + element);
		waitFor(element);
		boolean isDisplayed = element.isDisplayed();
		logger.info("Element displayed: " + isDisplayed);
		return isDisplayed;
	}

	public void scrollDown(int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixels + ")");
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public void tabOut(WebElement element) {
		element.sendKeys(Keys.TAB);
	}

	public void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
		logger.info("Entering text '" + text + "' into element: " + element);
	}

	public void enterNumber(WebElement element, int num) {
		element.clear();
		element.sendKeys(String.valueOf(num));
		logger.info("Entering text '" + num + "' into element: " + element);
	}

	public void waitFor(WebElement element) {
		wait1.until(driver -> element.isDisplayed());
		logger.info("Waits for element " + element.getTagName() + " to be displayed");
	}

	public void selectFromDropdown(WebElement dropdown, String value) {
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
		logger.info("Selecting value '" + value + "' from dropdown: " + dropdown);
	}
	
	public void closeCurrentTab() {
		driver.close();
	}

}
