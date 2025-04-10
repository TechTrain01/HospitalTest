package parallel;

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
	
	// Step to verify the user is on the Practo homepage
	@Given("I am on the homepage")
	public void i_am_on_the_homepage() {
		// Assert that the home cards are displayed on the homepage
		AssertJUnit.assertEquals(dp.isHomeCardsDisplayed(), true);
		// Log the verification of the homepage
		logger.info("Verified that the user is on the Practo homepage");
	}

	// Step to navigate to the diagnostics page
	@When("I navigate to the diagnostics page")
	public void i_navigate_to_the_diagnostics_page() {
		// Navigate to the diagnostics page
		dp.goToDiagnosticsPage();
	}

	// Step to verify the top cities banner pop-up is displayed
	@Then("I should see the top cities banner pop-up")
	public void i_should_see_the_top_cities_banner_pop_up() {
		// Manage consent if required
		dp.manageConsent();
		// Assert that the top cities card is displayed
		AssertJUnit.assertEquals(dp.isTopCitiesCardDisplayed(), true);
	}

	// Step to verify the top cities are visible
	@And("the top cities should be visible")
	public void the_top_cities_should_be_visible() {
		// Write the names of the top cities to an Excel file
		Utils.writeNamesToExcel(dp.extractNames(), "TopCities.xlsx");
	}

}
