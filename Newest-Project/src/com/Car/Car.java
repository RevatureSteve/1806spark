package com.Car;

public interface Car {

	String sound = "Vroom Vroom";
	
	public String drive();
	
	default String exhaustNote() {
		
		return sound;
	}
}
