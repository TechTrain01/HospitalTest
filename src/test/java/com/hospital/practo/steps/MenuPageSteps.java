package com.hospital.practo.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenuPageSteps {
	
	@Given("the user is on the Practo homepage")
	public void the_user_is_on_the_practo_homepage() {
		System.out.println("home page setup");
	}

	@When("the user enters {string} into the city search field")
	public void the_user_enters_into_the_city_search_field(String string) {
		System.out.println("added city name");
	}

	@And("the user selects {string} from the service type dropdown")
	public void the_user_selects_from_the_service_type_dropdown(String string) {
		System.out.println("added service type");
	}

	@And("the user clicks the {string} button")
	public void the_user_clicks_the_button(String string) {
		System.out.println("presed enter");
	}

	@Then("the user should be navigated to the list of hospitals in Bangalore")
	public void the_user_should_be_navigated_to_the_list_of_hospitals_in_bangalore() {
		System.out.println("navigated to menu page");
	}

	@And("the user should see a list of hospitals in Bangalore")
	public void the_user_should_see_a_list_of_hospitals_in_bangalore() {
		System.out.println("asserted this page");
	}

}
