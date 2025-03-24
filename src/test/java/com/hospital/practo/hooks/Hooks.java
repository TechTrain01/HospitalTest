package com.hospital.practo.hooks;

import com.pages.BasePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BasePage {

	@Before
	public void setUp() {
		browserSetUp();
	}

	@After
	public void tearDown() {
		closeWeb();
	}
}
