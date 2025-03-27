package com.pageTests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.pages.MenuPage;
import com.utils.PropertiesHandler;

public class HospitalListingsTest {
	
	MenuPage mn = new MenuPage();
	
	@Test
	public void setUp() {
		mn.goToMenuPage(PropertiesHandler.getProperty("city"),PropertiesHandler.getProperty("serviceType"));
		AssertJUnit.assertEquals(mn.isHospitalNumbersDisplayed(), true);
	}
	
	@Test
	public void testRatingAndOpeningsForEachHospital() {
		
	}

}
