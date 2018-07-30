package com.revature.pojo;

public class Hiking extends NationalParks{
	
	private String hikeName;
	private int hikeLength;

	public Hiking() {
		super();
	}

	public Hiking(String name, String location, String hikeName, int hikeLength) {
		super(name, location);
		this.hikeName = hikeName;
		this.hikeLength = hikeLength;
		System.out.println("Creating a new hike");
	}

	
	
	
}
