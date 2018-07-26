package com.downtime.abstracts;

/**
 * Car class is a template for creating a subclass for specific 
 * cars that are abstract
 * 
 * @author becklarson-Work
 *
 */

public abstract class Car {
	
	private String engine;
	private int seats;
	private static int doors;
	protected int miles;

	
	public Car() {
		
	}


	public Car(String engine, int seats, int doors, int miles) {
		super();
		this.engine = engine;
		this.seats = seats;
		this.setDoors(doors);
		this.miles = miles;
	}
	public static void addDoors() {
		setDoors(2);
	}
	
	public abstract void building();
	
	public int driveMiles() {
		miles++;
		return miles;
	}
	public int driveMiles(int milesDriven) {
		miles -= milesDriven;
		return miles;
	}
	
	public String getEngine() {
		return engine;
	}
	
	/**
	 * Set the type of engine;
	 * @param engine
	 */
	public void setEngine(String engine) {
		this.engine = engine;
	}


	public static int getDoors() {
		return doors;
	}


	public static void setDoors(int doors) {
		Car.doors = doors;
	}
	
}
