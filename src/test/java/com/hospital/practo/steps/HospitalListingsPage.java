package com.hospital.practo.steps;

import org.testng.AssertJUnit;

import com.pages.MenuPage;
import com.utils.PropertiesHandler;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HospitalListingsPage {

	MenuPage newHome = new MenuPage();

	@Given("the user is on the hospital Menu page")
	public void the_user_is_on_the_hospital_menu_page() {
		newHome.goToMenuPage(PropertiesHandler.getProperty("city"), PropertiesHandler.getProperty("serviceType"));
		AssertJUnit.assertEquals(newHome.isHospitalNumbersDisplayed(), true);
	}

	@When("the user clicks on the {string}")
	public void the_user_clicks_on_the(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be navigated to the hospital listings page")
	public void the_user_should_be_navigated_to_the_hospital_listings_page() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@And("the user should see the hospital opening times")
	public void the_user_should_see_the_hospital_opening_times() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@And("the user should see a rating of the hospital")
	public void the_user_should_see_a_rating_of_the_hospital() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user clciks the read more drop down")
	public void user_clciks_the_read_more_drop_down() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see parking in the Amenities block")
	public void the_user_should_see_parking_in_the_amenities_block() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
