package com.ex.cars;

public class Driver {
	
	public static void main(String[] args) {
		System.out.println("the showcase of cars");//make sure it works
		
		//car 1
		Car toyota = new Car();
		toyota.setBrand("Toyota");
		toyota.setModel("Corolla");
		toyota.cost = 19500;
		toyota.driver = "Danny";
		
		//car 2
		Car honda = new Car();
		honda.setBrand("Honda");
		honda.setModel("Civic");
		honda.cost = 18500;
		honda.driver = "Jerry";
		
		
		takeCar(toyota);
		takeCar(honda);
		
		
	}

	public static void takeCar(Car car) {
		System.out.println("Here is a description of a " + car);
	}

}
