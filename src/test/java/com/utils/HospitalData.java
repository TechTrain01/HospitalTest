package com.utils;

public class HospitalData {

	private String name;
	private String openingTimes;
	private String ratings;

	public HospitalData(String name, String openingTimes, String ratings) {
	        this.name = name;
	        this.openingTimes = openingTimes;
	        this.ratings = ratings;
	    }

	public String getName() {
		return name;
	}

	public String getOpeningTimes() {
		return openingTimes;
	}

	public String getRatings() {
		return ratings;
	}

}
