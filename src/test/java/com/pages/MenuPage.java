package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import com.utils.PageActions;
import com.utils.PropertiesHandler;

public class MenuPage extends BasePage {

	private static final Logger logger = LogManager.getLogger(MenuPage.class);
	WebDriver driver;
//	public static PropertiesHandler properties = new PropertiesHandler();
//	FluentWait<WebDriver> wait1;
	static PageActions pageActions;
//	private static final String CITY_FULL_NAME = PropertiesHandler.getProperty("Fullname");
//	private static final String XPATH_EXPRESSION = "//div[contains(@class, 'c-omni-suggestion-item__content__title') and contains(text(), '" + CITY_FULL_NAME + "')]";

	public MenuPage() {
		this.driver = browserSetUp();
		PageFactory.initElements(driver, this);
		this.pageActions = new PageActions(driver);
		logger.info("MenuPage initialized");
	}

//MAIN PAGE ELEMENTS:
	@FindBy(xpath = "//*[@id=\"c-omni-container\"]/div/div[1]/div/input")
	public static WebElement cityLocator;

//	public WebElement cityName(String cityName) {
//		WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds wait
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='c-omni-suggestion-item__content__title' and text()='" + cityName + "']")));
//    }

	@FindBy(xpath = "//div[contains(@class, 'c-omni-suggestion-item__content__title') and contains(text(), 'Bangalore')]")
	public static WebElement cityName;

	@FindBy(xpath = "//*[@id=\"c-omni-container\"]/div/div[2]/div/input")
	public static WebElement serviceLocator;

//	public WebElement serviceName(String serviceType) {
//        return driver.findElement(By.xpath("//div[@class='c-omni-suggestion-item__content__title' and text()='" + serviceType + "']"));
//    } 

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
	public void clickConsentButton() {
        consentButton.click();
    }
	
	public boolean isConsentButtonDisplayed() {
		return pageActions.isElementDisplayed(consentButton);
	}
	
	 public void manageConsent() {
	    	if(isConsentButtonDisplayed() == true) {
	    		clickConsentButton();
	    		logger.info("Clicked 'Do not consent'");
	    	}
	    }

	public void findParking() {
		pageActions.scrollDown(500);
		pageActions.isElementDisplayed(readMoreInfoElement);
		pageActions.clickElement(readMoreInfoElement);
		pageActions.scrollDown(300);
	}
	
	public boolean isParkingDisplayed() {
		return pageActions.isElementDisplayed(parkingElement);
	}

//MAIN PAGE METHODS:

	// Locator Methods
	public boolean isCityLocatorDisplayed() {
		return pageActions.isElementDisplayed(cityLocator);
	}

	public boolean isServiceLocatorDisplayed() {
		return pageActions.isElementDisplayed(serviceLocator);
	}

	public static boolean isHomeCardsDisplayed() {
		return pageActions.isElementDisplayed(homeCards);
	}

	// City Locator methods
	public static void clickCityLocator() {
		pageActions.clickElement(cityLocator);
	}

	public static void enterCity(String city) {
		pageActions.enterText(cityLocator, city);
	}

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

	public boolean isServiceNameDisplayed() {
		return pageActions.isElementDisplayed(serviceName);
	}

	public static void clickServiceType() {
		pageActions.clickElement(serviceName);
	}

//MENU PAGE METHODS

	public static void goToMenuPage(String city, String service) {
		clickCityLocator();
		enterCity(city);
		pageActions.waitFor(cityName);
		clickCityName();
		enterService(service);
		pageActions.waitFor(serviceName);
		clickServiceType();
	}

	public boolean isHospitalNumbersDisplayed() {
		return pageActions.isElementDisplayed(totalHospitals);
	}

	public boolean isRatingsDisplayed() {
		return pageActions.isElementDisplayed(rating);
	}

	public String getRating() {
		String ratings = rating.getText();
		return ratings;
	}

	public String getOpeningTime() {
		String Openings = openingTime.getText();
		return Openings;
	}

	public List<String> extractHospitalInfo() {
		List<String> hospitalInfo = new ArrayList<>();
		boolean consentManaged = false;

		for (WebElement card : hospitalCards) {
			try {
//                 Extract the rating text and convert it to a Double
				String ratingText = card.findElement(By.className("c-feedback")).findElement(By.className("u-bold"))
						.getText();
				Double rating = Double.parseDouble(ratingText);

				// Extract the opening time text
				String openingTime = card.findElement(By.className("pd-right-2px-text-green")).getText();

				// Check if the hospital meets the criteria
				if (openingTime.equals("Open 24x7") && rating >= 3.5) {
					// Extract the hospital name
					String title = card.findElement(By.className("line-1")).getText();
					String originalWindow = driver.getWindowHandle();
					System.out.println(originalWindow);

					pageActions.clickElement(card.findElement(By.className("line-1")));

					// locating new Tab that appears
					for (String windowHandle : driver.getWindowHandles()) {
						if (!windowHandle.equals(originalWindow)) {
							System.out.println(windowHandle);
							driver.switchTo().window(windowHandle);
							break;
						}
					}

					// initialise the parking page class
//					HopsitalParkingPage parkingPage = new HopsitalParkingPage();
//					parkingPage.manageConsent();
//					parkingPage.findParking();
//					manageConsent();
					
					//So that manage consent only occurs once
					if (!consentManaged) {
	                    manageConsent();
	                    consentManaged = true; // Set flag to true after managing consent
	                }
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
				System.out.println("Invalid rating: " + rating);
			} catch (NoSuchElementException e) {
				System.out.println("Element not found: " + e.getMessage());
			}
		}

		return hospitalInfo;
	}

	public static void clickHospitalName() {
		pageActions.clickElement(hospitalName);

	}

}
