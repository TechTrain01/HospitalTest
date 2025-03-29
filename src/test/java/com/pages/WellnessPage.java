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
	
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/span")
	public WebElement wellnessTab;
	
	
	
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
    private WebElement scheduleDemoButton;
	
	
	public void goToWellness() {
		clickWellnessTab();
		clickWellnessBtn();
	}
	
	public boolean isFormContainerDisplayed() {
		return pageActions.isElementDisplayed(formContainer);
    }
	
	public void clickWellnessTab() {
		pageActions.clickElement(wellnessTab);
	}
	
	public void clickWellnessBtn() {
		pageActions.isElementDisplayed(wellnessBtn);
		pageActions.clickElement(wellnessBtn);
	}
	
	public void enterName(String yourName) {
        pageActions.enterText(nameInput, yourName);
        pageActions.tabOut(nameInput);
    }
	
	public void enterOrganizationName(String organizationName) {
        pageActions.enterText(organizationNameInput, organizationName);
        pageActions.tabOut(organizationNameInput);
    }
	
	public void enterContactNumber(int contactNumber) {
		pageActions.enterNumber(contactNumberInput, contactNumber);
		pageActions.tabOut(contactNumberInput);
    }
	
	public void enterContactTextNumber(String contactNumber) {
		pageActions.enterText(contactNumberInput, contactNumber);
		pageActions.tabOut(contactNumberInput);
    }
	
	public void enterOfficialEmailId(String officialEmailId) {
		pageActions.enterText(officialEmailIdInput, officialEmailId);
		pageActions.tabOut(officialEmailIdInput);
    }
	
	public void selectOrganizationSize(String size) {
        pageActions.selectFromDropdown(organizationSizeSelect, size);
    }
	
	public void selectInterestedIn(String interest) {
		pageActions.selectFromDropdown(interestedInSelect, interest);
    }
	
	public void clickScheduleDemoButton() {
        scheduleDemoButton.click();
    }
	

}
