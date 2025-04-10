package com.pageTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.pages.DiagnosticsPage;
import com.utils.Report;
import com.utils.Utils;

public class TopCitiesTest {

    // Logger instance for logging information
    private static final Logger logger = LogManager.getLogger(TopCitiesTest.class);
    private ExtentReports extent;
    private ExtentTest test;
    DiagnosticsPage diag = new DiagnosticsPage();
    
    @BeforeClass
    public void createReport() {
        // Initialize ExtentReports instance
        extent = Report.getInstance();
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
    public void setUpPageTest() {
        try {
            // Assert that the home cards are displayed on the homepage
            AssertJUnit.assertEquals(diag.isHomeCardsDisplayed(), true);
            // Log the verification of the homepage
            logger.info("Verified that the user is on the Practo homepage");
            test.pass("Verified that the user is on the Practo homepage");
        } catch (Exception e) {
            logger.error("Error in setUpPageTest: ", e);
            test.fail("Error in setUpPageTest: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void goToDiagnosisPageTest() {
        try {
            // Navigate to the diagnostics page
            diag.goToDiagnosticsPage();
            logger.info("Navigated to the diagnostics page");
            test.pass("Navigated to the diagnostics page");
        } catch (Exception e) {
            logger.error("Error in goToDiagnosisPageTest: ", e);
            test.fail("Error in goToDiagnosisPageTest: " + e.getMessage());
        }
    }
    
    @Test(priority = 3)
    public void manageConsentTest() {
        try {
            // Manage consent if required
            diag.manageConsent();
            // Assert that the top cities card is displayed
            AssertJUnit.assertEquals(diag.isTopCitiesCardDisplayed(), true);
            logger.info("Top cities card is displayed");
            test.pass("Top cities card is displayed");
        } catch (Exception e) {
            logger.error("Error in manageConsentTest: ", e);
            test.fail("Error in manageConsentTest: " + e.getMessage());
        }
    }
    
    @Test(priority = 4)
    public void createExcelReport() {
        try {
            // Write the names of the top cities to an Excel file
            Utils.writeNamesToExcel(diag.extractNames(), "TopCities.xlsx");
            logger.info("Top cities names written to Excel file");
            test.pass("Top cities names written to Excel file");
        } catch (Exception e) {
            logger.error("Error in createExcelReport: ", e);
            test.fail("Error in createExcelReport: " + e.getMessage());
        }
    }
    
    @AfterClass
    public void tearDown() {
        try {
            test.info("Starting teardown process...");
            diag.closeWeb();
            // Log the successful teardown
            logger.info("Teardown process completed successfully.");
            test.pass("Teardown process completed successfully.");
        } catch (Exception e) {
            logger.error("Error in tearDown: ", e);
            test.fail("Error in tearDown: " + e.getMessage());
        } finally {
            // Flush the ExtentReports instance
            Report.tearDownExtentReports();
        }
    }
}
