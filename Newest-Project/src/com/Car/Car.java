package com.Car;

public interface Car {

	String sound = "Vroom Vroom";
	
	public void drive();
	
	default String exhaustNote() {
		
		return sound;
	}
}
