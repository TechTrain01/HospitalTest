package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.PageActions;

public class MenuPage extends BasePage {

	// Logger instance for logging information
	private static final Logger logger = LogManager.getLogger(MenuPage.class);
	WebDriver driver;
	static PageActions pageActions;

	// Constructor to initialize the page elements and setup the browser
	public MenuPage() {
		this.driver = browserSetUp();
		PageFactory.initElements(driver, this);
		this.pageActions = new PageActions(driver);
		// Log the initialization of the MenuPage
		logger.info("MenuPage initialized");
	}

//MAIN PAGE ELEMENTS:
	@FindBy(xpath = "//*[@id=\"c-omni-container\"]/div/div[1]/div/input")
	public static WebElement cityLocator;

	@FindBy(xpath = "//div[contains(@class, 'c-omni-suggestion-item__content__title') and contains(text(), 'Bangalore')]")
	public static WebElement cityName;

	@FindBy(xpath = "//*[@id=\"c-omni-container\"]/div/div[2]/div/input")
	public static WebElement serviceLocator;

	@FindBy(xpath = "//div[contains(@class, 'c-omni-suggestion-item') and .//div[text()='Hospital'] and .//span[text()='TYPE']]")
	public static WebElement serviceName;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[3]/div/div/div/div")
	public static WebElement homeCards;

//MENU PAGE ELEMENTS:
	@FindBy(xpath = "//h1[contains(text(), 'Hospitals in Bangalore')]")
	public WebElement totalHospitals;

	@FindBy(css = ".c-estb-card")
	List<WebElement> hospitalCards;

	@FindBy(className = "line-1")
	WebElement hospitalTitle;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[1]/ol/li[1]/div/div[2]/div[1]/div/span[2]/span")
	public WebElement openingTime;

	@FindBy(css = "span.u-bold")
	public WebElement rating;

	@FindBy(css = "line-1")
	public static WebElement hospitalName;

//HOSPITAL PARKING PAGE ELEMENTS
	@FindBy(css = "div.pure-u-1 > span[data-qa-id='read_more_info']")
	WebElement readMoreInfoElement;

	@FindBy(css = "span.u-spacer--right-less.p-entity__item-title-label[data-qa-id='amenity_item']")
	WebElement parkingElement;

	@FindBy(xpath = "/html/body/div[6]/div[2]/div[2]/div[2]/div/div[1]/h1")
	private WebElement consentDialog;

	@FindBy(css = "button.fc-button.fc-cta-consent.fc-primary-button")
	WebElement consentButton;

//HOSPITAL PARKING PAGE METHODS
	// Method that returns boolean for appearance of button
	public boolean isConsentButtonDisplayed() {
		return pageActions.isElementDisplayed(consentButton);
	}

	// Method that clicks consentButton
	public void clickConsentButton() {
		consentButton.click();
	}

	// Method that checks isConsentButtonDisplayed before clicking
	public void manageConsent() {
		if (isConsentButtonDisplayed() == true) {
			clickConsentButton();
			logger.info("Clicked 'Do not consent'");
		}
	}

	// Method that navigates to parking amenities
	public void findParking() {
		pageActions.scrollDown(500);
		pageActions.isElementDisplayed(readMoreInfoElement);
		pageActions.clickElement(readMoreInfoElement);
		pageActions.scrollDown(300);
	}

	// Method that returns boolean for appearance of parking
	public boolean isParkingDisplayed() {
		return pageActions.isElementDisplayed(parkingElement);
	}

//MAIN PAGE METHODS:
	// Method that returns boolean for appearance of cityLocator
	public boolean isCityLocatorDisplayed() {
		return pageActions.isElementDisplayed(cityLocator);
	}

	// Method that returns boolean for appearance of ServiceLocator
	public boolean isServiceLocatorDisplayed() {
		return pageActions.isElementDisplayed(serviceLocator);
	}

	// Method that returns boolean for appearance of homeCard
	public static boolean isHomeCardsDisplayed() {
		return pageActions.isElementDisplayed(homeCards);
	}

	// Method that clicks on cityLocator
	public static void clickCityLocator() {
		pageActions.clickElement(cityLocator);
	}

	// Method that enters city name as input
	public static void enterCity(String city) {
		pageActions.enterText(cityLocator, city);
	}

	// Method that returns boolean for city cityName
	public boolean isCityNameDisplayed() {
		return pageActions.isElementDisplayed(cityName);
	}

	public static void clickCityName() {
		pageActions.clickElement(cityName);
	}

	// Service Locator Methods
	public static void enterService(String service) {
		pageActions.enterText(serviceLocator, service);
	}

	//Returns boolean if serviceName is displayed or not
	public boolean isServiceNameDisplayed() {
		return pageActions.isElementDisplayed(serviceName);
	}

	//clicks on serviceType
	public static void clickServiceType() {
		pageActions.clickElement(serviceName);
	}

//MENU PAGE METHODS

	//Navigates to menu page
	public static void goToMenuPage(String city, String service) {
		clickCityLocator();
		enterCity(city);
		pageActions.waitFor(cityName);
		clickCityName();
		enterService(service);
		pageActions.waitFor(serviceName);
		clickServiceType();
	}
	
	//metho to click on hospital name
	public static void clickHospitalName() {
		pageActions.clickElement(hospitalName);

	}

	//method to check the number of hosipitals
	public boolean isHospitalNumbersDisplayed() {
		return pageActions.isElementDisplayed(totalHospitals);
	}

	//method to check if rating is displayed
	public boolean isRatingsDisplayed() {
		return pageActions.isElementDisplayed(rating);
	}

	//Method to get rating
	public String getRating() {
		String ratings = rating.getText();
		return ratings;
	}

	//method to get openingtime 
	public String getOpeningTime() {
		String Openings = openingTime.getText();
		return Openings;
	}

	//Method used to extract list of hospitals that meet requirements
	public List<String> extractHospitalInfo() {
		List<String> hospitalInfo = new ArrayList<>();
		boolean consentManaged = false;

		for (WebElement card : hospitalCards) {
			try {
				// Extract the rating text and convert it to a Double
				String ratingText = card.findElement(By.className("c-feedback")).findElement(By.className("u-bold"))
						.getText();
				Double rating = Double.parseDouble(ratingText);

				// Extract the opening time text
				String openingTime = card.findElement(By.className("pd-right-2px-text-green")).getText();

				// Check if the hospital meets the criteria
				if (openingTime.equals("Open 24x7") && rating >= 3.5) {
					// Extract the hospital names
					String title = card.findElement(By.className("line-1")).getText();
					// Extracts the window handle for the MenuPage
					String originalWindow = driver.getWindowHandle();
					// Clicks on name of hospital
					pageActions.clickElement(card.findElement(By.className("line-1")));

					// locating new Tab that appears
					for (String windowHandle : driver.getWindowHandles()) {
						if (!windowHandle.equals(originalWindow)) {
							System.out.println(windowHandle);
							driver.switchTo().window(windowHandle);
							break;
						}
					}

					// If statement to check whether the cookie pop up appears
					if (!consentManaged) {
						manageConsent();
						consentManaged = true; // Set flag to true after managing consent
					}
					// Find parking method called
					findParking();
					// Check if each hospital website has parking or not.
					if (isParkingDisplayed() == true) {
						hospitalInfo.add(title);
						logger.info("Parking was displayed");
					}
					// close current tab
					pageActions.closeCurrentTab();

					// go back to original window
					driver.switchTo().window(originalWindow);
				}
			} catch (NumberFormatException e) {
				logger.error("Invalid rating: " + e.getMessage());
			} catch (NoSuchElementException e) {
				logger.error("Element not found: " + e.getMessage());
			}
		}

		return hospitalInfo;
	}
}
