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

	@Given("the user is on the Corporate Wellness page")
	public void the_user_is_on_the_corporate_wellness_page() {
		wp.goToWellness();
		AssertJUnit.assertEquals(wp.isFormContainerDisplayed(), true);
	}

	@When("the user fills in details with {string}, {string}, {string}, {string}")
	public void the_user_fills_in_details_with(String name, String orgName, String number, String email) {
		wp.enterName(name);
		wp.enterOrganizationName(orgName);
		wp.enterContactTextNumber(number);
		wp.enterOfficialEmailId(email);
		wp.scroll();

	}

	@And("selects {string} from the first dropdown")
	public void selects_an_option_from_the_first_dropdown(String size) {
		wp.selectOrganizationSize(size);
	}

	@And("selects {string} from the second dropdown")
	public void selects_an_option_from_the_second_dropdown(String interest) {
		wp.selectInterestedIn(interest);
	}

	@Then("the user should see respective invalid inputs highlighted in red")
	public void the_user_should_see_respective_invalid_inputs_highlighted_in_red() {
		AssertJUnit.assertEquals(wp.isInputHighlightedInRed(wp.getContactNumberInput()), false);
		AssertJUnit.assertEquals(wp.isInputHighlightedInRed(wp.getOfficialEmailIdInput()), false);
	}

	@And("the schedule button is greyed out")
	public void the_schedule_button_is_greyed_out() {
		AssertJUnit.assertEquals(wp.isScheduleButtonGreyed(wp.scheduleDemoButton), true);
	}
	
	@When("the user clicks on the Schedule button")
    public void the_user_clicks_on_the_schedule_button() {
		System.out.println("test");
        wp.clickScheduleDemoButton();
    }

    @Then("the user should see Successful pop-up notification")
    public void the_user_should_see_successful_pop_up_notification() {
    	AssertJUnit.assertEquals(wp.isThankYouPopUpDisplayed(), true);
        
    }

}
