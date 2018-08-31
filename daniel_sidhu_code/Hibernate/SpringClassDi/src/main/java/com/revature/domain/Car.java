package com.revature.domain;

public class Car {

	private String name;
	private String color;
	
	private Engine engine;
	
	public Car() {}

	public Car(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	public Car(String name) {
		super();
		this.name = name;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
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

	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", engine=" + engine + "]";
	}

}
