package com.practice2;

import com.practive2.exception.NoNegativeArgException;

public class Driver {

	public static void main(String[] args) {
		
		Cars cayman = new Cars("3.5l flat6", true);
		int caymanDoors = 2;
		if(caymanDoors >= 0) {
			cayman.setDoors(caymanDoors);
		}else {
			throw new NoNegativeArgException("You can't do that!");
		}
		Cars golf = new Cars();
		golf.setEngine("4 cyl");
		golf.setGasoline(true);
		int golfDoors = 4;
		if(golfDoors >= 0) {
			golf.setDoors(golfDoors);
		}else {
			throw new NoNegativeArgException("You can't do that!");
		}
		
		makeCars(cayman);
		makeCars(golf);

	}
	
	public static void makeCars(Cars car) {
		System.out.println(car);
	}

}
