package com.revature.bean;

public class Car {
	
	private String name;
	private String color;
	private int maxSpeed;
	private Engine engine;
	
	public Car() {
		super();
	}
	
	

	public Car(String name) {
		super();
		this.name = name;
	}



	public Car(String name, String color, int maxSpeed, Engine engine) {
		super();
		this.name = name;
		this.color = color;
		this.maxSpeed = maxSpeed;
		this.engine = engine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", maxSpeed=" + maxSpeed + ", engine=" + engine + "]";
	}
	
	
	
	
}
