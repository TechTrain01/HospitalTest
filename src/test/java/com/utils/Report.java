package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Report {
    private static ExtentReports extent;
    private static ExtentTest test;
    private static final Logger logger = LogManager.getLogger(Report.class);

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Create an instance of ExtentSparkReporter
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/ExtentReport.html");

            // Configure the reporter
            sparkReporter.config().setDocumentTitle("Automation Report");
            sparkReporter.config().setReportName("Selenium Test Results");
            sparkReporter.config().setTheme(Theme.STANDARD);

            // Create an instance of ExtentReports and attach the reporter
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            // Log the creation of the ExtentReports instance
            logger.info("ExtentReports instance created and configured.");
        }
        return extent;
    }
    
    public static ExtentTest getTest(String testName) {
        if (test == null) {
            test = getInstance().createTest(testName);
        }
        return test;
    }

    public static void tearDownExtentReports() {
        if (extent != null) {
            // Flush the ExtentReports instance
            extent.flush();
            // Log the cleanup of ExtentReports resources
            logger.info("ExtentReports resources cleaned up.");
        }
    }
}