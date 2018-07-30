package com.revature.abstracts;

import com.revature.exceptions.EmptyStringException;

public abstract class Attractions {

	private String name;
	private String location;

	
	
	public Attractions() {
		super();
	}
	
	public Attractions(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * Do not try and set name as an empty string
	 * @param name
	 * @throws EmptyStringException
	 */
	public void setName(String name) throws EmptyStringException {
		if (name == "") {
			throw new EmptyStringException();
		}else {
			this.name = name;
		}
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * print out where attraction is located
	 */
	public void findAttraction() {
		System.out.println(name + " is located at " + location );
	}
	
	
	public abstract void whatToDo();
	
	public abstract void printAttractionInfo();
	
	
	
	
	
}
