package com.pageTests;

import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.pages.MenuPage;
import com.utils.PropertiesHandler;

public class HospitalListingsTest {

	MenuPage mn = new MenuPage();

	@Test(priority = 1)
	public void setUp() {
		mn.goToMenuPage(PropertiesHandler.getProperty("city"), PropertiesHandler.getProperty("serviceType"));
		AssertJUnit.assertEquals(mn.isHospitalNumbersDisplayed(), true);
	}

	@Test(priority = 2)
	public void print_All_Hopsitals_With_Rating_And_Opening() {
//		mn.extractHospitalInfo();
		System.out.println(mn.extractHospitalInfo());
	}

}
