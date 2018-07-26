package com.practice;

import com.practice.exceptions.NoNegativeArgException;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Cars...");
		Cars eclipse = new Cars("6G75", true);
		int eclipseDoors = 2;
		if(eclipseDoors >= 0) {
			eclipse.doors = eclipseDoors;
		}else {
			throw new NoNegativeArgException("The can must have more than 0 doors... come on...");
		}
		Cars frs = new Cars();
		frs.setEngine("Boxer");
		frs.setGasoline(true);
		int frsDoors = 2;
		if(frsDoors >= 0) {
			frs.doors = frsDoors;
		}else {
			throw new NoNegativeArgException("The can must have more than 0 doors... come on...");
		}
		
		makeCar(eclipse);
		makeCar(frs);
		
	}
	
	public static void makeCar(Cars car) {
		System.out.println(car);
	}
}
