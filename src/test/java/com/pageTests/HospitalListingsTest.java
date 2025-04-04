package com.pageTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.pages.BasePage;
import com.pages.MenuPage;
import com.utils.PropertiesHandler;
import com.utils.Report;
import com.utils.Utils;

public class HospitalListingsTest {

	// Logger instance for logging information
	private static final Logger logger = LogManager.getLogger(BasePage.class);
	private ExtentReports extent;
	private ExtentTest test;
	MenuPage mn = new MenuPage();
	
	@BeforeClass
    public void createReport() {
        // Initialize ExtentReports instance
        extent = Report.getInstance();
        // Create a test instance in the report
     // Create a test instance in the report
        test = Report.getTest("Hospital Listings Test");

        // Log the start of the setup process
        logger.info("Starting setup process...");
        test.info("Starting setup process...");

        // Log the successful setup
        logger.info("Setup process completed successfully.");
        test.pass("Setup process completed successfully.");
    }

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
        test.pass("Data extraction process completed successfully.");
	}
	
	
	@AfterClass
	public void tearDown() {
		test.info("Starting teardown process...");
		BasePage.closeWeb();
		// Log the successful teardown
        logger.info("Teardown process completed successfully.");
     // Flush the ExtentReports instance
        Report.tearDownExtentReports();
        test.pass("Teardown process completed successfully.");
	}

}
