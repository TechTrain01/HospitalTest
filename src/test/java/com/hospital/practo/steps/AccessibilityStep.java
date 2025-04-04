package com.hospital.practo.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import com.deque.html.axecore.results.Results;
import com.pages.MenuPage;
import com.utils.AxeAccessibilityChecker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccessibilityStep {
	private AxeAccessibilityChecker axeChecker;
	private static final Logger logger = LogManager.getLogger(AccessibilityStep.class);
	
	//Creating an axeChekcer instance from MenuPage class driver
	@Given("I open the browser and navigate to home page")
	public void i_open_the_browser_and_navigate_to() {
		logger.info("Setting up the browser and navigating to the home page.");
		axeChecker = new AxeAccessibilityChecker(MenuPage.browserSetUp());
	}
	
	//Checking and creating a log for all accessibility violations
	@Then("I check the page for accessibility issues")
	public void i_check_the_page_for_accessibility_issues() {
		logger.info("Analyzing the page for accessibility issues.");
		Results results = axeChecker.analyzePage();
		logger.info("Accessibility analysis completed.");
//		axeChecker.logViolationsToFile(results);
		// Get the results as JSON
        JSONObject jsonResults = axeChecker.getViolationsAsJson(results);
        logger.info("Accessibility violations JSON: " + jsonResults.toString());
        //Save the JSON to a file
        axeChecker.saveJsonToFile(jsonResults, "accessibilityReport.json");
	}


}
