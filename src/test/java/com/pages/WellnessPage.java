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
	public WebElement scheduleDemoButton;
    
    @FindBy(css = ".ReactModal__Content.ReactModal__Content--after-open")
    private WebElement thankYouModel;

	
	
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
	
	public void scroll() {
        pageActions.scrollDown(100);
    }
	
	public boolean isInputHighlightedInRed(WebElement element) {
        String borderColor = element.getCssValue("border-color");
        String textColor = element.getCssValue("color");
        String expectedBorderColor = Color.fromString("#e0b4b4").asRgba();
        String expectedTextColor = Color.fromString("#9f3a38").asRgba();
        
//        System.out.println("Border Color: " + borderColor);
//        System.out.println("Text Color: " + textColor);
        
        return borderColor.equals(expectedBorderColor) && textColor.equals(expectedTextColor);
    }
	
	public boolean isScheduleButtonGreyed(WebElement element) {
		String backGroundColour = element.getCssValue("background-color");
		String expectedBackgroundColour = Color.fromString("#b4b4be").asRgba();
		return backGroundColour.equals(expectedBackgroundColour);
	}
	
	public WebElement getContactNumberInput() {
        return contactNumberInput;
    }

    public WebElement getOfficialEmailIdInput() {
        return officialEmailIdInput;
    }
    
    public boolean isThankYouPopUpDisplayed() {
		return pageActions.isElementDisplayed(thankYouModel);
    }
	

}
