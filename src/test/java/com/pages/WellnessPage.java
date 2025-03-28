package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.PageActions;

public class WellnessPage extends BasePage {
	private static final Logger logger = LogManager.getLogger(MenuPage.class);
	PageActions pageActions;
	WebDriver driver;
	
	
	public WellnessPage() {
		this.driver = browserSetUp();
		PageFactory.initElements(driver, this);
		this.pageActions = new PageActions(driver);
		logger.info("WellnessPage initialized");
	}
	
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/div[2]/div[1]/div[1]/div[2]/div/div[3]/div[1]/span")
	public WebElement wellnessTab;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/div[2]/div[1]/div[1]/div[2]/div/div[3]/div[1]/span/div/div[1]/a")
	public WebElement wellnessBtn;
	
	
	public void goToWellness() {
		clickWellnessTab();
		clickWellnessBtn();
	}
	
	public void clickWellnessTab() {
		pageActions.clickElement(wellnessTab);
	}
	
	public void clickWellnessBtn() {
		pageActions.isElementDisplayed(wellnessBtn);
		pageActions.clickElement(wellnessBtn);
	}

}
