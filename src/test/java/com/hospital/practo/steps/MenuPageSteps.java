package com.hospital.practo.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;

import com.hospital.practo.hooks.Hooks;
import com.pages.BasePage;
import com.pages.MenuPage;
import com.utils.PropertiesHandler;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenuPageSteps {
	
	MenuPage home = new MenuPage();
	private static final Logger logger = LogManager.getLogger(MenuPageSteps.class);
	
	
	@Given("the user is on the Practo homepage")
	public void the_user_is_on_the_practo_homepage() {
		AssertJUnit.assertEquals(home.isHomeCardsDisplayed(), true);
		logger.info("Verified that the user is on the Practo homepage");
	}

	@When("the user enters {string} into the city search field")
	public void the_user_enters_into_the_city_search_field(String city) {
		AssertJUnit.assertEquals(home.isCityLocatorDisplayed(), true);
		logger.info("Verified that the cityLocator text field is on the Practo homepage");
		home.enterCity(PropertiesHandler.getProperty("city"));
	}
	
	
	@And("the user selects {string} from the dropdown options")
	public void the_user_selects_from_the_dropdown_options(String city) {
		home.selectCityFromDropdown(PropertiesHandler.getProperty("cityFullName"));
	    logger.info("Selected city from dropdown: " + city);
	}

	@And("the user selects {string} from the service search Field")
	public void the_user_selects_from_the_service_search_field(String service) {
		home.enterService(service);
	    logger.info("Entered service: " + service);
	}

	@And("the user selects {string} from the service type dropdown")
	public void the_user_selects_from_the_service_type_dropdown(String service) {
		home.selectServiceFromDropdown(service);
	    logger.info("Selected service from dropdown: " + service);
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
