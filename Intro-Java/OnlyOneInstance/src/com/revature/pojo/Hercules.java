package com.revature.pojo;

/*
 * Hercules is an object we want to restrict to only one instance: Singleton
 * 
 * 		What does a singleton require?
 * 			control the constructor by encapsulating them with private
 */

public class Hercules {
	
	private static Hercules hercules;
	private String name;
	
	private Hercules() {
		name = "Hercules";
	}
	public static Hercules getHercules() {
		if(hercules == null) {
			hercules = new Hercules();
		}
		return hercules;
	}
	public String getName() {
		return name;
	}	
}