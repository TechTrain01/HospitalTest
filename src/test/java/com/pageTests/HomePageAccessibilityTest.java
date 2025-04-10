package com.pageTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.pages.MenuPage;
import com.utils.AxeAccessibilityChecker;
import com.utils.Report;
import com.utils.Utils;

public class HomePageAccessibilityTest {
    private static final Logger logger = LogManager.getLogger(HomePageAccessibilityTest.class);
    private ExtentReports extent;
    private ExtentTest test;
    private AxeAccessibilityChecker axeChecker;
    MenuPage mp;
   

    @BeforeClass
    public void createReport() {
        // Initialize ExtentReports instance
        extent = Report.getInstance();
        // Create a test instance in the report
        test = extent.createTest("Accessibility test for home page");

        // Log the start of the setup process
        logger.info("Starting setup process...");
        test.info("Starting setup process...");

        // Log the successful setup
        logger.info("Setup process completed successfully.");
        test.pass("Setup process completed successfully.");
    }

    @Test
    public void testAccessibility() {
        // Initialize AxeAccessibilityChecker with the WebDriver instance
        axeChecker = new AxeAccessibilityChecker(mp.browserSetUp());
        axeChecker.axeHome(test);
//        Utils.bringToFront(mp.driver);
    }

    @AfterClass
    public void tearDown() {
        // Log the start of the teardown process
        logger.info("Starting teardown process...");
        test.info("Starting teardown process...");

        // Close the web driver
        mp.closeWeb();

        // Log the successful teardown
        logger.info("Teardown process completed successfully.");
        test.pass("Teardown process completed successfully.");

        // Flush the ExtentReports instance
        Report.tearDownExtentReports();
    }
}