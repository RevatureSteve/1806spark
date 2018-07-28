package com.ex.cars;

//class
public class Car {

	//var
	private String brand;
	private String model;
	public int cost;
	public String driver;
	
	//NO-ARGS
	public Car() {}

	//constructor with fields
	public Car(String brand, String model, int cost, String driver) {
		super();
		this.brand = brand;
		this.model = model;
		this.cost = cost;
		this.driver = driver;
	}

	//getters and setters for brand and model
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	//toString for my arguments
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", model=" + model + ", cost=" + cost + ", driver=" + driver + "]";
	}
	
	
}
