package com.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.deque.html.axecore.results.AxeResults;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.practo.steps.AccessibilityStep;
import com.pages.MenuPage;

public class AxeAccessibilityChecker {
	
	private WebDriver driver;
	private static final Logger logger = LogManager.getLogger(AxeAccessibilityChecker.class);

    public AxeAccessibilityChecker(WebDriver driver) {
        this.driver = driver;
    }

    public Results analyzePage() {
        AxeBuilder builder = new AxeBuilder();
        return builder.analyze(driver);
    }
    
    public void logViolationsToFile(Results results) {
        try (FileWriter writer = new FileWriter("accessibility-violations.log")) {
            writer.write(results.getViolations().toString());
            logger.info("Accessibility violations logged to file.");
        } catch (IOException e) {
            logger.error("Error writing accessibility violations to file.", e);
        }
    }

	public JSONObject getViolationsAsJson(Results results) {
		return new JSONObject(results);
	}
	
	public void saveJsonToFile(JSONObject jsonResults, String fileName) {
		try (FileWriter file = new FileWriter(fileName)) {
            file.write(jsonResults.toString(4)); // Pretty print with an indent of 4 spaces
            logger.info("Accessibility report saved to " + fileName);
        } catch (IOException e) {
            logger.error("Error saving accessibility report to file: " + e.getMessage());
        }
    }
	
//	public void addJsonToExtentReport(JSONObject jsonResults) {
//        // Add JSON report to Extent report using ExtentCucumberAdapter
//        ExtentCucumberAdapter.addTestStepLog("Accessibility Violations JSON: " + jsonResults.toString(4)); // Pretty print with an indent of 4 spaces
//        logger.info("Accessibility JSON report added to Extent report.");
//    }
	
	public void axeHome(ExtentTest test) {
		AxeBuilder bob = new AxeBuilder();
		
		try {
			Results res = bob.analyze(MenuPage.browserSetUp());
			
			if(res.violationFree()) {
				test.pass("No accessibility violations found here");
			}else {
				test.fail("Accessibility violations detected on this page");
				res.getViolations().forEach(violation -> {
					test.info("Violation:" + violation.getDescription());
					test.info("Violation:" + violation.getImpact());
					test.info("Violation:" + violation.getTags());
				});
				
				throw new Exception("Accessibility violations found for this page");
			}
		} catch (Exception e) {
			test.fail("Error during accessibility testing for this page");
		}
	}
	

}
