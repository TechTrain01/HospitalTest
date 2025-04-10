package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.PageActions;

public class WellnessPage extends BasePage {
	// Logger instance for logging information
	private static final Logger logger = LogManager.getLogger(MenuPage.class);
	PageActions pageActions;
	WebDriver driver;

	// Constructor to initialize the page elements and setup the browser
	public WellnessPage() {
		this.driver = browserSetUp();
		PageFactory.initElements(driver, this);
		this.pageActions = new PageActions(driver);
		// Log the initialization of the WellnessPage
		logger.info("WellnessPage initialized");
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/span")
	public WebElement wellnessTab;

//WELLNESS PAGE ELEMENTS
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/span/div/div[1]")
	public WebElement wellnessBtn;

	@FindBy(css = ".form-container")
	private WebElement formContainer;

	@FindBy(id = "name")
	private WebElement nameInput;

	@FindBy(id = "organizationName")
	private WebElement organizationNameInput;

	@FindBy(id = "contactNumber")
	private WebElement contactNumberInput;

	@FindBy(id = "officialEmailId")
	private WebElement officialEmailIdInput;

	@FindBy(id = "organizationSize")
	private WebElement organizationSizeSelect;

	@FindBy(id = "interestedIn")
	private WebElement interestedInSelect;

	@FindBy(css = "button[type='submit']")
	public WebElement scheduleDemoButton;

	@FindBy(css = ".ReactModal__Content.ReactModal__Content--after-open")
	private WebElement thankYouModel;

//WELLNESS PAGE METHODS
	// Method to navigate to the Wellness page
	public void goToWellness() {
		clickWellnessTab();
		clickWellnessBtn();
	}

	// Method to check if the form container is displayed
	public boolean isFormContainerDisplayed() {
		return pageActions.isElementDisplayed(formContainer);
	}

	// Method to click on the wellness tab
	public void clickWellnessTab() {
		pageActions.clickElement(wellnessTab);
	}

	// Method to click on the wellness button
	public void clickWellnessBtn() {
		pageActions.isElementDisplayed(wellnessBtn);
		pageActions.clickElement(wellnessBtn);
	}

	// Method to enter the user's name
	public void enterName(String yourName) {
		pageActions.enterText(nameInput, yourName);
		pageActions.tabOut(nameInput);
	}

	// Method to enter the organization's name
	public void enterOrganizationName(String organizationName) {
		pageActions.enterText(organizationNameInput, organizationName);
		pageActions.tabOut(organizationNameInput);
	}

	// Method to enter the contact number as an integer
	public void enterContactNumber(int contactNumber) {
		pageActions.enterNumber(contactNumberInput, contactNumber);
		pageActions.tabOut(contactNumberInput);
	}

	// Method to enter the contact number as a string
	public void enterContactTextNumber(String contactNumber) {
		pageActions.enterText(contactNumberInput, contactNumber);
		pageActions.tabOut(contactNumberInput);
	}

	// Method to enter the official email ID
	public void enterOfficialEmailId(String officialEmailId) {
		pageActions.enterText(officialEmailIdInput, officialEmailId);
		pageActions.tabOut(officialEmailIdInput);
	}

	// Method to select the organization size from the dropdown
	public void selectOrganizationSize(String size) {
		pageActions.selectFromDropdown(organizationSizeSelect, size);
	}

	// Method to select the area of interest from the dropdown
	public void selectInterestedIn(String interest) {
		pageActions.selectFromDropdown(interestedInSelect, interest);
	}

	// Method to click the schedule demo button
	public void clickScheduleDemoButton() {
		scheduleDemoButton.click();
	}

	// Method to scroll down the page by 100 pixels
	public void scroll() {
		pageActions.scrollDown(100);
	}

	// Method to check if an input element is highlighted in red
	public boolean isInputHighlightedInRed(WebElement element) {
		String borderColor = element.getCssValue("border-color");
		String textColor = element.getCssValue("color");
		String expectedBorderColor = Color.fromString("#e0b4b4").asRgba();
		String expectedTextColor = Color.fromString("#9f3a38").asRgba();
		// Log the border and text color for debugging purposes
        logger.debug("Border Color: " + borderColor);
        logger.debug("Text Color: " + textColor);

		return borderColor.equals(expectedBorderColor) && textColor.equals(expectedTextColor);
	}

	// Method to check if the schedule button is greyed out
	public boolean isButtonWorking(WebElement element) {
		Boolean notWorking = element.isEnabled();
		return notWorking;
	}

	// Method to get the contact number input element
	public WebElement getContactNumberInput() {
		return contactNumberInput;
	}

	// Method to get the official email ID input element
	public WebElement getOfficialEmailIdInput() {
		return officialEmailIdInput;
	}

	// Method to check if the thank you pop-up is displayed
	public boolean isThankYouPopUpDisplayed() {
		return pageActions.isElementDisplayed(thankYouModel);
	}

}
