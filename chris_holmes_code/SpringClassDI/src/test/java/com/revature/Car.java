package com.revature;

public class Car {

	private String name;
	private String color;
	
	//Car has-a Engine
	private Engine engine;
	
	public Car(String name, String color, Engine engine) {
		super();
		this.name = name;
		this.color = color;
		this.engine = engine;
	}

	public Car() {

	}

	

	public Car(String name) {
		super();
		this.name = name;
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

	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + "]";
	}
	
	
	
	
}
