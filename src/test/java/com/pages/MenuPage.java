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
	PageActions pageActions;
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
	public WebElement cityLocator;

//	public WebElement cityName(String cityName) {
//		WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds wait
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='c-omni-suggestion-item__content__title' and text()='" + cityName + "']")));
//    }

	@FindBy(xpath = "//div[contains(@class, 'c-omni-suggestion-item__content__title') and contains(text(), 'Bangalore')]")
	public WebElement cityName;

	@FindBy(xpath = "//*[@id=\"c-omni-container\"]/div/div[2]/div/input")
	public WebElement serviceLocator;

//	public WebElement serviceName(String serviceType) {
//        return driver.findElement(By.xpath("//div[@class='c-omni-suggestion-item__content__title' and text()='" + serviceType + "']"));
//    } 

	@FindBy(xpath = "//div[contains(@class, 'c-omni-suggestion-item') and .//div[text()='Hospital'] and .//span[text()='TYPE']]")
	public WebElement serviceName;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[3]/div/div/div/div")
	public WebElement homeCards;

//MENU PAGE ELEMENTS:
	@FindBy(xpath = "//h1[contains(text(), 'Hospitals in Bangalore')]")
	public WebElement totalHospitals;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[1]/ol/li[1]/div/div[2]/div[1]/div/span[2]/span")
	public WebElement openingTime;

	@FindBy(css = ".c-estb-card")
	List<WebElement> hospitalCards;
	
	@FindBy(className = "line-1")
	WebElement hospitalTitle;
	
	

	@FindBy(css = "span.u-bold")
	public WebElement rating;

	@FindBy(css = "h2.line-1")
	public WebElement hospitalName;

//MAIN PAGE METHODS:

	// Locator Methods
	public boolean isCityLocatorDisplayed() {
		return pageActions.isElementDisplayed(cityLocator);
	}

	public boolean isServiceLocatorDisplayed() {
		return pageActions.isElementDisplayed(serviceLocator);
	}

	public boolean isHomeCardsDisplayed() {
		return pageActions.isElementDisplayed(homeCards);
	}

	// City Locator methods
	public void clickCityLocator() {
		pageActions.clickElement(cityLocator);
	}

	public void enterCity(String city) {
		pageActions.enterText(cityLocator, city);
	}

	public boolean isCityNameDisplayed() {
		return pageActions.isElementDisplayed(cityName);
	}

	public void clickCityName() {
		pageActions.clickElement(cityName);
	}

	// Service Locator Methods
	public void enterService(String service) {
		pageActions.enterText(serviceLocator, service);
	}

	public boolean isServiceNameDisplayed() {
		return pageActions.isElementDisplayed(serviceName);
	}

	public void clickServiceType() {
		pageActions.clickElement(serviceName);
	}

//MENU PAGE METHODS

	public void goToMenuPage(String city, String service) {
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

//	public String extractHospitalInfo() {
//		List<String> hospitalInfo = new ArrayList<>();
//
//		for (WebElement card : hospitalCards) {
//			if (getOpeningTime().equals("Open 24x7") && getRating() >= 3.5) {
//				hospitalInfo.add(card.getText());
//			}
//		}
//
//		return hospitalInfo.toString();
//	}
	
//	public List<String> extractHospitalInfo() {
//        List<String> hospitalInfo = new ArrayList<>();
//        
//        for (WebElement card : hospitalCards) {
//            try {
//                Double rating = Double.parseDouble(getRating());
//                if (openingTime.equals("Open 24x7")) {
//                    hospitalInfo.add(card.getText());
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid rating: " + getRating());
//            }
//        }
//        
//        return hospitalInfo;
//    }
	
//	public List<String> extractHospitalInfo() {
//        List<String> hospitalInfo = new ArrayList<>();
//        
//        for (WebElement card : hospitalCards) {
//        	String title = card.findElement(By.className("line-1")).getText();
//        	hospitalInfo.add(title);
//        }
//        
//        return hospitalInfo;
//    }
	
	
	public List<String> extractHospitalInfo() {
        List<String> hospitalInfo = new ArrayList<>();
        
        for (WebElement card : hospitalCards) {
            try {
                // Extract the rating text and convert it to a Double
//            	String ratingText = card.rating.getText();
//                Double rating = Double.parseDouble(ratingText);

                // Extract the opening time text
                String openingTime = card.findElement(By.className("pd-right-2px-text-green")).getText();

                // Check if the hospital meets the criteria
                if (openingTime.equals("Open 24x7") && getRating().equals("4.0")) {
                    // Extract the hospital name
                    String title = card.findElement(By.className("line-1")).getText();
                    hospitalInfo.add(title);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid rating: " + rating);
            } catch (NoSuchElementException e) {
                System.out.println("Element not found: " + e.getMessage());
            }
        }
        
        return hospitalInfo;
    }

}
