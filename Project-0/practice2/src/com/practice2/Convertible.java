package com.practice2;

public interface Convertible {
	
	
	boolean isConvertible();
	
	default String welcomeMessage() {
		
		return "Lets build a car!";
	}
}
