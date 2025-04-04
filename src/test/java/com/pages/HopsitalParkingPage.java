package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.PageActions;

public class HopsitalParkingPage{

	// Logger instance for logging information
	private static final Logger logger = LogManager.getLogger(HopsitalParkingPage.class);
	WebDriver driver;
	PageActions pageActions;

	// Constructor to initialize the page elements and setup the page actions
	public HopsitalParkingPage() {
		PageFactory.initElements(driver, this);
		this.pageActions = new PageActions(driver);
		logger.info("MenuPage initialized");
	}

	//Each Hospital Page
	@FindBy(xpath = "//*[@id=\"react-tabs-13441\"]/div/div[1]/div[3]/div/span/span")
	WebElement readMoreInfoElement;

	@FindBy(css = "span.u-spacer--right-less.p-entity__item-title-label[data-qa-id='amenity_item']")
	WebElement parkingElement;
	
	@FindBy(css = "button.fc-button.fc-cta-consent.fc-primary-button")
    WebElement consentButton;
	
	// Method to check if the consent button is displayed
	public boolean isConsentButtonDisplayed() {
		return pageActions.isElementDisplayed(consentButton);
	}
    
	// Method to click the consent button
    public void clickConsentButton() {
        consentButton.click();
    }
	
 // Method to manage consent by clicking the consent button if displayed
	 public void manageConsent() {
	    	if(isConsentButtonDisplayed() == true) {
	    		clickConsentButton();
	    		// Log the action of clicking 'Do not consent'
	    		logger.info("Clicked 'Do not consent'");
	    	}else {
	    		// Log that the consent dialog was not displayed
	    		logger.info("Consent dialog not displayed");
	    	}
	    }

	// Method to find parking by scrolling down and clicking the read more info element
	public void findParking() {
		pageActions.scrollDown(100);
		pageActions.isElementDisplayed(readMoreInfoElement);
		pageActions.clickElement(readMoreInfoElement);
		pageActions.scrollDown(100);
	}
	
	// Method to check if the parking element is displayed
	public boolean isParkingDisplayed() {
		return pageActions.isElementDisplayed(parkingElement);
	}


}
