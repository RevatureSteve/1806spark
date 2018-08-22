package com.revature.abstracts;

public abstract class House {
	private int numberOfBedrooms;
	private int numberOfBathrooms;
	private String color;
	protected int livingSpace;
	
	public House() {}
	public House(int numberOfBedrooms, int numberOfBathroom, String color, int size) {
		super();
		this.numberOfBedrooms = numberOfBedrooms;
		this.numberOfBathrooms = numberOfBathroom;
		this.color = color;
		this.livingSpace = livingSpace;
	}
	
	public abstract void building();
	
	public int sublet() {
		this.livingSpace--;
		return this.livingSpace;
	}
	
	public int sublet(int tenantSpace) {
		this.livingSpace -= tenantSpace;
		return this.livingSpace;
	}

	public int getNumberOfBedrooms() {
		return this.numberOfBedrooms;
	}
	

	public void setNumberOfBedrooms(int numberOfBedrooms) {
		if(numberOfBedrooms < 0) {
			System.out.println("Cannot have a negative value for numberOfBedroom, setting it to 0");
			this.numberOfBedrooms = 0;
		} else {
			this.numberOfBedrooms = numberOfBedrooms;
		}
	}
}
