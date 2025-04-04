package com.hospital.practo.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;

import com.pages.MenuPage;
import com.pages.WellnessPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WellnessPageSteps {

	WellnessPage wp = new WellnessPage();
	private static final Logger logger = LogManager.getLogger(WellnessPageSteps.class);

	// Step to navigate to the Corporate Wellness page and verify the form container is displayed
	@Given("the user is on the Corporate Wellness page")
	public void the_user_is_on_the_corporate_wellness_page() {
		// Navigate to the Corporate Wellness page
		wp.goToWellness();
		// Assert that the form container is displayed on the page
		AssertJUnit.assertEquals(wp.isFormContainerDisplayed(), true);
	}

	// Step to fill in the details in the form
	@When("the user fills in details with {string}, {string}, {string}, {string}")
	public void the_user_fills_in_details_with(String name, String orgName, String number, String email) {
		wp.enterName(name);
		wp.enterOrganizationName(orgName);
		wp.enterContactTextNumber(number);
		wp.enterOfficialEmailId(email);
		wp.scroll();

	}

	// Step to select an option from the first dropdown
	@And("selects {string} from the first dropdown")
	public void selects_an_option_from_the_first_dropdown(String size) {
		// Select the organization size from the dropdown
		wp.selectOrganizationSize(size);
	}

	// Step to select an option from the second dropdown
	@And("selects {string} from the second dropdown")
	public void selects_an_option_from_the_second_dropdown(String interest) {
		// Select the area of interest from the dropdown
		wp.selectInterestedIn(interest);
	}

	// Step to verify that invalid inputs are highlighted in red
	@Then("the user should see respective invalid inputs highlighted in red")
	public void the_user_should_see_respective_invalid_inputs_highlighted_in_red() {
		// Assert that the contact number input is not highlighted in red
		AssertJUnit.assertEquals(wp.isInputHighlightedInRed(wp.getContactNumberInput()), false);
		// Assert that the official email ID input is not highlighted in red
		AssertJUnit.assertEquals(wp.isInputHighlightedInRed(wp.getOfficialEmailIdInput()), false);
	}

	// Step to verify that the schedule button is greyed out
	@And("the schedule button is greyed out")
	public void the_schedule_button_is_greyed_out() {
		// Assert that the schedule button is greyed out
		AssertJUnit.assertEquals(wp.isScheduleButtonGreyed(wp.scheduleDemoButton), true);
	}
	
	// Step to click on the Schedule button
	@When("the user clicks on the Schedule button")
    public void the_user_clicks_on_the_schedule_button() {
		// Click on the schedule demo button
        wp.clickScheduleDemoButton();
    }

	// Step to verify that the successful pop-up notification is displayed
    @Then("the user should see Successful pop-up notification")
    public void the_user_should_see_successful_pop_up_notification() {
    	// Assert that the thank you pop-up is displayed
    	AssertJUnit.assertEquals(wp.isThankYouPopUpDisplayed(), true);
        
    }

}
