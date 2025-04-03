package com.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import com.deque.html.axecore.results.AxeResults;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.practo.steps.AccessibilityStep;

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
    

//    public void printViolations(AxeResults results) {
//        JSONObject responseJson = Results();
//    }
//    
//    public boolean doesContainViolations(AxeResults results) {
//    	
//    }

}
