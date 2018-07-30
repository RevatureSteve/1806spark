package com.Car;

public class Sedan implements Car{
	
	private int advancedFeatures;
	private int cylinder;
	private int seats;
	private String model;
	
	public Sedan() {}

	public Sedan(int advancedFeatures, int cylinder, int seats, String model) {
		super();
		this.advancedFeatures = advancedFeatures;
		this.cylinder = cylinder;
		this.seats = seats;
		this.model = model;
	}

	public int getAdvancedFeatures() {
		return advancedFeatures;
	}

	public void setAdvancedFeatures(int advancedFeatures) {
		this.advancedFeatures = advancedFeatures;
	}

	public int getCylinder() {
		return cylinder;
	}

	public void setCylinder(int cylinder) {
		this.cylinder = cylinder;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public void drive() {
		System.out.println("The car drives!");
		
	}

	@Override
	public String toString() {
		return "Sedan [advancedFeatures=" + advancedFeatures + ", cylinder=" + cylinder + ", seats=" + seats
				+ ", model=" + model + "]";
	}
	
	
	
	
}
