package com.revature.interfaces;

public interface Visitable {

	boolean canVisit = true;
	
	public static void visiting(String name) {
		System.out.println("You are visiting " + name + "!");
	}
	
	void visited();

}
