package com.hospital.practo.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;

import com.pages.DiagnosticsPage;
import com.utils.Utils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TopCitiesSteps {
	
	DiagnosticsPage dp = new DiagnosticsPage();
	private static final Logger logger = LogManager.getLogger(TopCitiesSteps.class);
	
	@Given("I am on the homepage")
	public void i_am_on_the_homepage() {
		AssertJUnit.assertEquals(dp.isHomeCardsDisplayed(), true);
		logger.info("Verified that the user is on the Practo homepage");
	}

	@When("I navigate to the diagnostics page")
	public void i_navigate_to_the_diagnostics_page() {
		dp.goToDiagnosticsPage();
	}

	@Then("I should see the top cities banner pop-up")
	public void i_should_see_the_top_cities_banner_pop_up() {
		dp.manageConsent();
		AssertJUnit.assertEquals(dp.isTopCitiesCardDisplayed(), true);
	}

	@And("the top cities should be visible")
	public void the_top_cities_should_be_visible() {
		Utils.writeDataToExcel(dp.extractNames(), "TopCities.xlsx");
	}

}
