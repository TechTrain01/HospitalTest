package com.hospital.practo.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.pages.MenuPage;
import com.utils.PropertiesHandler;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenuPageSteps {
	
	MenuPage home = new MenuPage();
	private static final Logger logger = LogManager.getLogger(MenuPageSteps.class);
	
	// Step to verify the user is on the Practo homepage
	@Given("the user is on the Practo homepage")
	public void the_user_is_on_the_practo_homepage() {
		// Assert that the home cards are displayed on the homepage
		AssertJUnit.assertEquals(MenuPage.isHomeCardsDisplayed(), true);
		 // Log the verification of the homepage
		logger.info("Verified that the user is on the Practo homepage");
	}

	// Step to enter the city into the city search field
	@When("the user enters {string} into the city search field")
	public void the_user_enters_into_the_city_search_field(String city) {
		// Assert that the city locator text field is displayed on the homepage
		AssertJUnit.assertEquals(home.isCityLocatorDisplayed(), true);
		// Log the verification of the city locator text field
		logger.info("Verified that the cityLocator text field is on the Practo homepage");
		// Enter the city into the city search field
		MenuPage.enterCity(PropertiesHandler.getProperty("city"));
	}
	
	// Step to select the city from the dropdown options
	@And("the user selects {string} from the dropdown options")
	public void the_user_selects_from_the_dropdown_options(String city) {
		// Assert that the city name is displayed in the dropdown
		AssertJUnit.assertEquals(home.isCityNameDisplayed(), true);
		// Click on the city name in the dropdown
		MenuPage.clickCityName();
		// Log the selection of the city from the dropdown
	    logger.info("Selected city from dropdown: " + city);
	}

	// Step to enter the service into the service search field
	@And("the user enters {string} from the service search Field")
	public void the_user_selects_from_the_service_search_field(String service) {
		// Enter the service into the service search field
		MenuPage.enterService(service);
		// Log the entry of the service into the search field
	    logger.info("Entered service: " + service);
	}

	// Step to select the service type from the dropdown
	@And("the user selects {string} from the service type dropdown")
	public void the_user_selects_from_the_service_type_dropdown(String service) {
		// Assert that the service name is displayed in the dropdown
		AssertJUnit.assertEquals(home.isServiceNameDisplayed(), true);
		// Click on the service type in the dropdown
		MenuPage.clickServiceType();
		// Log the selection of the service type from the dropdown
	    logger.info("Selected service from dropdown: " + service);
	}

	// Step to verify navigation to the list of hospitals in Bangalore
	@Then("the user should be navigated to the list of hospitals in Bangalore")
	public void the_user_should_be_navigated_to_the_list_of_hospitals_in_bangalore() {
		// Assert that the hospital numbers are displayed on the page
		Assert.assertEquals(home.isHospitalNumbersDisplayed(), true);
		// Log the successful display of the hospital numbers
		logger.info("Element succefully displayed: " +home.totalHospitals);
	}

}
