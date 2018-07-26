package com.downtime.pojo;

import com.downtime.abstracts.Car;

public class SportsCar extends Car{
	
	private int driveTrain;
	private int horsePower;
	public int zeroToSixty;
	
	public SportsCar() {
		
	}
	
	

	public SportsCar(int driveTrain, int horsePower, int miles) {
		super();
		this.driveTrain = driveTrain;
		this.horsePower = horsePower;
		this.miles = miles;
	}



	@Override
	public int driveMiles() {
		System.out.println("Driving the car!");
		return miles;
	}



	@Override
	public void building() {
		System.out.println("The car is building...");
		System.out.println("The car has " + getDoors() + " doors");
		
	}
	


}
