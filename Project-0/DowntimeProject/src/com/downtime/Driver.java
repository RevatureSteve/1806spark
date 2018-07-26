package com.downtime;

import com.downtime.pojo.SportsCar;

public class Driver {
	
	public static void main(String[] args) {
		System.out.println("Lets build some cars!");
		
		SportsCar c = new SportsCar();
		c.setEngine("6g75");
		System.out.println("The engine is a: " + c.getEngine());
		SportsCar.addDoors();
		System.out.println(SportsCar.getDoors());
		
		
	}
}
