package com.hospital.practo.hooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pages.BasePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks{
	private static final Logger logger = LogManager.getLogger(Hooks.class);

	@Before
	public void setUp() {
//		browserSetUp();
	}

	@After
	public void tearDown() {
//		BasePage.closeWeb();
		logger.info("@AFTER: Webpage closed");
	}
}
