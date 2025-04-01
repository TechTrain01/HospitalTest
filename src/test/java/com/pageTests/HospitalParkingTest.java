package com.pageTests;

import org.testng.annotations.Test;

import com.pages.HopsitalParkingPage;
import com.pages.MenuPage;

public class HospitalParkingTest extends MenuPage{

	HopsitalParkingPage parkingPage = new HopsitalParkingPage();

	@Test(priority = 1)
	public void enterHospitalParkingPage() {
		
		parkingPage.manageConsent();
	}

	@Test(priority = 2)
	public void print_All_Hopsitals_With_Rating_And_Opening() {

	}

}
