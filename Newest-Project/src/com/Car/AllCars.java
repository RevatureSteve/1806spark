
//A

package com.Car;

import java.io.Serializable;

public abstract class AllCars implements Serializable {
	
	private static final long serialVersionUID = 6421;
 
	public int cylinders;
	public int seats;
	public String model;
	
	public abstract void homeMsg();
	
	public AllCars() {
		
	}



	public AllCars(int cylinders, int seats, String model) {
		super();
		this.cylinders = cylinders;
		this.seats = seats;
		this.model = model;
	}
	

	public int getCylinders() {
		return cylinders;
	}

	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AllCars [cylinders=" + cylinders + ", seats=" + seats + ", model=" + model + "]";
	}

	
	
	
	
	
}
