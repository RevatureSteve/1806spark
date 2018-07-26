package com.revature.pojo;

import com.revature.abstracts.Attractions;
import com.revature.exceptions.NoEmptyStringException;
import com.revature.exceptions.NoNegativeException;

public class Lighthouses extends Attractions {

	private String location;
	private int height;
	private boolean isWorking;

	public Lighthouses() {
	}

	public Lighthouses(String name, String location, int height, boolean isWorking, boolean isOpen) {
		super(name, isOpen);
		this.location = location;
		this.height = height;
		this.isWorking = isWorking;
	}

	@Override
	public String toString() {
		return "Name: " + name + "\nLocation: " + location + "\nHeight: " + height + "\nWorking: " + isWorking
				+ "\nOpen: " + isOpen() + "\n";
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if (height < 0) {
			this.height = 0;
			throw new NoNegativeException();
		} else {
			this.height = height;
		}

	}

	public boolean isWorking() {
		return isWorking;
	}

	public void setWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) throws NoEmptyStringException {
		
		if(location == "") {
			throw new NoEmptyStringException();
		} else {
			this.location = location;
		}
		
	}


}
