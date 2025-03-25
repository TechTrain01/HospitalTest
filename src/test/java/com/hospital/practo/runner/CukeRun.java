package com.hospital.practo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
/*,
plugin= {"html:target/cucumber-reports/cucmber-html-report.html",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
*/

@CucumberOptions(features="src/test/resources/features/homeSite.feature", glue= {"com/hospital/practo/steps", "com/hospital/practo/hooks"},
plugin= {"html:target/cucumber-reports/cucmber-html-report.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class CukeRun extends AbstractTestNGCucumberTests{

}
