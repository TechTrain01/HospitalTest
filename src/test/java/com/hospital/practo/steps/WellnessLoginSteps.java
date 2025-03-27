package com.hospital.practo.steps;

import com.pages.MenuPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WellnessLoginSteps {
	
	MenuPage newHome = new MenuPage();
	
	@Given("the user is on the Corporate Wellness page")
	public void the_user_is_on_the_corporate_wellness_page() {
	 
	}

	@When("the user fills in details with {string}, {string}, {string}, {string}, {string}, and {string}")
	public void the_user_fills_in_details_with_and(String name, String org,String contact, String email,
			String dropDown1, String dropDown2) {
	    
	}

	@When("the user schedules an appointment")
	public void the_user_schedules_an_appointment() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see a warning message")
	public void the_user_should_see_a_warning_message() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
