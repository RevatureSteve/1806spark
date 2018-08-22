package com.revature;

import com.revature.pojo.HouseA;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Going to choose a house");
		
		HouseA a = new HouseA();
		int userInpt = -100;
		if(userInpt >= 0) {
			a.setNumberOfBedrooms(userInpt);
		}
		System.out.println(a.getNumberOfBedrooms());
	}

}
