package com.hospital.practo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = { "com/hospital/practo/steps",
		"com/hospital/practo/hooks" }, tags = "@topCities", plugin = {
				"html:target/cucumber-reports/cucmber-html-report.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class CukeRun extends AbstractTestNGCucumberTests {

}
