package com.hospital.practo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = { "com/hospital/practo/steps",
		"com/hospital/practo/hooks" }, tags = "@invalidLoginInput", plugin = {
				"html:reports/cucumber-reports/cucmber-html-report.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class CukeRun extends AbstractTestNGCucumberTests {
//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//		return super.scenarios();
}
