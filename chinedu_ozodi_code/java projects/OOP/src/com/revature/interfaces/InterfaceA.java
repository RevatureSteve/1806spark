package com.revature.interfaces;

public interface InterfaceA {	
	
	String interfaceString = "This is an interface string";

	void useInterface(InterfaceA interfaceA);
	
	public default void concreteInterfaceMethod() {
		System.out.println("This is a concrete interface method, introduced in java 1.8");
	}
}
