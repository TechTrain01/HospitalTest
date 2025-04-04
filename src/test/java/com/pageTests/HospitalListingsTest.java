package com.pageTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.pages.BasePage;
import com.pages.MenuPage;
import com.utils.PropertiesHandler;
import com.utils.Utils;

public class HospitalListingsTest {

	// Logger instance for logging information
	private static final Logger logger = LogManager.getLogger(BasePage.class);
	MenuPage mn = new MenuPage();

	@Test(priority = 1)
	public void setUp() {
		// Log the start of the setup process
        logger.info("Starting setup process...");
        // Navigate to the menu page with the specified city and service type
		MenuPage.goToMenuPage(PropertiesHandler.getProperty("city"), PropertiesHandler.getProperty("serviceType"));
		// Assert that the hospital numbers are displayed
		AssertJUnit.assertEquals(mn.isHospitalNumbersDisplayed(), true);
		// Log the successful setup
        logger.info("Setup process completed successfully.");
	}

	@Test(priority = 2)
	public void print_All_Hopsitals_With_Rating_And_Opening(){
		// Log the start of the data extraction process
        logger.info("Starting data extraction process...");
        // Write the extracted hospital information to an Excel file
		Utils.writeDataToExcel(mn.extractHospitalInfo(), "Hospitals.xlsx");
		// Log the successful data extraction
        logger.info("Data extraction process completed successfully.");
	}
	
	
	@AfterClass
	public void tearDown() {
		BasePage.closeWeb();
		// Log the successful teardown
        logger.info("Teardown process completed successfully.");
	}

}
