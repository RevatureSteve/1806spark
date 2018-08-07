package com.revature.pojo;

import java.io.Serializable;

import com.revature.abstracts.Attractions;
import com.revature.exceptions.NoNegativeException;
import com.revature.interfaces.Visitable;

public class Lighthouse extends Attractions implements Serializable, Visitable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int height;
	private boolean isWorking;
	private static String typeOfAttraction = "Lighthouse";
	private boolean visited;
	
	
	public Lighthouse() {
	}
	
	
	public Lighthouse(String name, String location, int height, boolean isWorking) {
		super(name, location);
		this.height = height;
		this.isWorking = isWorking;
		System.out.println("New lighthouse being created");
	}


	public int getHeight() {
		return height;
	}

	
	/**
	 * Setting int height
	 * 		If height is less then 0 then I will set height to 0
	 * @param height
	 * @throws NoNegativeException
	 */
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


	
	public static String getTypeOfAttraction() {
		return typeOfAttraction;
	}


	@Override
	public String toString() {
		return "Lighthouse [name=" + super.getName() + " location=" + super.getLocation()  + " height=" + height + ", isWorking=" + isWorking + "]";
	}


	@Override
	public void visited() {
		System.out.println("You have now visited " + getName() + "!");
		System.out.println("Did you get to climb the lighthouse?");
		this.visited = true;
	}


	@Override
	public void whatToDo() {
		System.out.println("Climb the lighthouse!");
	}


	@Override
	public void printAttractionInfo() {
		System.out.println("Name: " + getName() + "\nLocation: " + getLocation() + "\nHeight: " + height + "\nVisited: " + visited);
		
	}


	
	
	
	
	
	
}
