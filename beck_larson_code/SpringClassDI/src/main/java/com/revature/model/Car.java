package com.revature.model;

public class Car {

	
	
	private String name;
	private String color;
	
	private Engine engine;
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Car(String name) {
		super();
		this.name = name;
	}


	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", engine=" + engine + "]";
	}


	public Car(String name, String color, Engine engine) {
		super();
		this.name = name;
		this.color = color;
		this.engine = engine;
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
	
	
}
