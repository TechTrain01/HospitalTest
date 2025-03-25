package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import com.utils.PageActions;
import com.utils.PropertiesHandler;



public class MenuPage extends BasePage{
	
	private static final Logger logger = LogManager.getLogger(MenuPage.class);
	WebDriver driver;
	PropertiesHandler properties = new PropertiesHandler();
	FluentWait<WebDriver> wait1;
	PageActions pageActions;
	
	@FindBy(xpath = "//*[@id=\"c-omni-container\"]/div/div[1]/div/input")
	public WebElement cityLocator;
	
	@FindBy(xpath = "//*[@id=\"c-omni-container\"]/div/div[1]/div[2]/div[2]/div[1]/span[1]/div")
	public WebElement cityName;
	
	@FindBy(xpath = "//*[@id=\"c-omni-container\"]/div/div[2]/div/input")
	public WebElement serviceLocator;
	
	@FindBy(xpath = "//*[@id=\"c-omni-container\"]/div/div[2]/div[2]/div[1]/div[5]/span[1]/div")
	public WebElement serviceName;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[3]/div/div/div/div")
	public WebElement homeCards;
	
	public MenuPage() {
		this.driver = browserSetUp();
		PageFactory.initElements(driver, this);
		this.pageActions = new PageActions(driver);
		logger.info("MenuPage initialized");
	}
	
	//make methods: does home page button exist
	//then use the test classes to assert it to be true
	
	public boolean isCityLocatorDisplayed() {
        return PageActions.isElementDisplayed(cityLocator);
    }

    public boolean isServiceLocatorDisplayed() {
        return PageActions.isElementDisplayed(serviceLocator);
    }

    public boolean isHomeCardsDisplayed() {
        return PageActions.isElementDisplayed(homeCards);
    }

    public void clickCityLocator() {
        pageActions.clickElement(cityLocator);
    }

    public void enterCity(String city) {
        pageActions.enterText(cityLocator, city);
    }


    public boolean isCityNameDisplayed() {
        return PageActions.isElementDisplayed(cityName);
    }
    
    public void clickCityName() {
        pageActions.clickElement(cityName);
    }

	public void enterService(String service) {
		pageActions.enterText(serviceLocator, service);
		
	}

	public void selectServiceFromDropdown(String service) {
		pageActions.selectFromDropdown(serviceLocator, service);
		
	}
	
	public boolean isServiceNameDisplayed() {
        return PageActions.isElementDisplayed(serviceName);
    }

	public void clickServiceType() {
		pageActions.clickElement(serviceName);
		
	}

}
