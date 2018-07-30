//D

package com.Car;

public class lilCar extends SportsCar {

	public int mpg;
	
	public lilCar() {}

	public lilCar(int horsePower,int cylinders, int seats, String model, int mpg) {
		super(horsePower, cylinders, seats, model);
		System.out.println("Building your new " + model);
		this.mpg = mpg;
	}

	public int getMpg() {
		return mpg;
	}

	public void setMpg(int mpg) {
		this.mpg = mpg;
	}

	@Override
	public String toString() {
		return super.toString() + " [mpg=" + mpg + "]";
	}
	
	
	
	
	
	
}
