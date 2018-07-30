package com.car;

public interface Car {
	
	public void drive();
	default void hello() {
		System.out.println("Hi");
	}

}
