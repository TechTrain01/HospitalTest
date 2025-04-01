package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pageTests.HospitalParkingTest;
import com.utils.PageActions;
import com.utils.PropertiesHandler;

public class HopsitalParkingPage{

	private static final Logger logger = LogManager.getLogger(HopsitalParkingPage.class);
	WebDriver driver;
	PageActions pageActions;

	public HopsitalParkingPage() {
		PageFactory.initElements(driver, this);
		this.pageActions = new PageActions(driver);
		logger.info("MenuPage initialized");
	}

	@FindBy(xpath = "//*[@id=\"react-tabs-13441\"]/div/div[1]/div[3]/div/span/span")
	WebElement readMoreInfoElement;

	@FindBy(css = "span.u-spacer--right-less.p-entity__item-title-label[data-qa-id='amenity_item']")
	WebElement parkingElement;
	
	@FindBy(xpath = "/html/body/div[6]/div[2]/div[2]/div[2]/div/div[1]/h1")
	private WebElement consentDialog;

	@FindBy(xpath = "/html/body/div[6]/div[2]/div[2]/div[3]/div[2]/button[2]")
	private WebElement doNotConsentButton;
	
	@FindBy(css = "button.fc-button.fc-cta-consent.fc-primary-button")
    WebElement consentButton;


//	public void goToPage() {
//		MenuPage.goToMenuPage(PropertiesHandler.getProperty("city"), PropertiesHandler.getProperty("serviceType"));
//		MenuPage.clickHospitalName();
//	}
	
	public boolean isConsentDialogDisplayed() {
        return pageActions.isElementDisplayed(consentDialog);
    }
	
	public boolean isConsentButtonDisplayed() {
		return pageActions.isElementDisplayed(consentButton);
	}

    public void clickDoNotConsent() {
        pageActions.clickElement(doNotConsentButton);
    }
    
    public void clickConsentButton() {
        consentButton.click();
    }
	
	 public void manageConsent() {
	    	if(isConsentButtonDisplayed() == true) {
	    		clickConsentButton();
	    		logger.info("Clicked 'Do not consent'");
	    	}else {
	    		logger.info("Consent dialog not displayed");
	    	}
	    }

	public void findParking() {
		pageActions.scrollDown(100);
		pageActions.isElementDisplayed(readMoreInfoElement);
		pageActions.clickElement(readMoreInfoElement);
		pageActions.scrollDown(100);
	}
	
	public boolean isParkingDisplayed() {
		return pageActions.isElementDisplayed(parkingElement);
	}


}
