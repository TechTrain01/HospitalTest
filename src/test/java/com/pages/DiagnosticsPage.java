package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.PageActions;

public class DiagnosticsPage extends BasePage {

	// Logger instance for logging information
	private static final Logger logger = LogManager.getLogger(MenuPage.class);
	WebDriver driver;
	PageActions pageActions;

	// Constructor to initialize the page elements and setup the browser
	public DiagnosticsPage() {
		this.driver = browserSetUp();
		PageFactory.initElements(driver, this);
		this.pageActions = new PageActions(driver);
		// Log the initialization of the BasePage
		logger.info("BasePage initialized");
	}

	// MAIN PAGE ELEMENTS:

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[3]/div/div/div/div")
	public WebElement homeCards;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[3]/a/div[1]")
	public WebElement surgeries;

	@FindBy(xpath = "//*[@id=\"__next\"]/main/div/div[1]/div/div[3]/div/div[2]/div[4]/a/div[1]")
	public WebElement labTests;

	@FindBy(css = ".ReactModal__Content.ReactModal__Content--after-open")
	private WebElement citySelectorCard;

	@FindBy(xpath = "//*[@id=\"locationInput\"]")
	public WebElement cityLocator;

	@FindBy(css = "ul.u-br-rule.u-marginb--std-half.u-pointer.u-padb--dbl.o-flex.o-flex__justify--between li .u-margint--standard.o-f-color--primary")
	private List<WebElement> topCityNames;

	@FindBy(css = ".fc-dialog.fc-choice-dialog")
	private WebElement consentDialog;

	@FindBy(css = ".fc-button.fc-cta-do-not-consent")
	private WebElement doNotConsentButton;

	// Method to check if home cards are displayed
	public boolean isHomeCardsDisplayed() {
		return pageActions.isElementDisplayed(homeCards);
	}

	// Method to click on the surgeries button
	public void clickSurgeriesBtn() {
		pageActions.clickElement(surgeries);
	}

	// Method to click on the lab tests button
	public void clickLabTestBtn() {
		pageActions.clickElement(labTests);
	}

	// Method to navigate to the diagnostics page
	public void goToDiagnosticsPage() {
		clickSurgeriesBtn();
		clickLabTestBtn();
	}

	// Method to check if the top cities card is displayed
	public boolean isTopCitiesCardDisplayed() {
		return pageActions.isElementDisplayed(citySelectorCard);
	}

	// Method to make the top cities card appear if not already displayed
	public void getCardToAppear() {
		if (isTopCitiesCardDisplayed() == false) {
			pageActions.clickElement(cityLocator);
		}
	}

	// Method to extract names of top cities
	public List<String> extractNames() {
		List<String> topCities = new ArrayList<>();
		for (WebElement cityName : topCityNames) {
			topCities.add(cityName.getText());
		}
		return topCities;
	}

	// Method to check if the consent dialog is displayed
	public boolean isConsentDialogDisplayed() {
		return pageActions.isElementDisplayed(consentDialog);
	}

	// Method to click the 'Do not consent' button
	public void clickDoNotConsent() {
		pageActions.clickElement(doNotConsentButton);
	}

	// Method to manage consent by clicking 'Do not consent' if the dialog is displayed
	public void manageConsent() {
		if (isConsentDialogDisplayed() == true) {
			clickDoNotConsent();
			logger.info("Clicked 'Do not consent'");
		} else {
			logger.info("Consent dialog not displayed");
		}
	}

}
