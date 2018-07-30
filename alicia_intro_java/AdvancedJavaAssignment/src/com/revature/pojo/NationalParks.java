package com.revature.pojo;

import java.io.Serializable;
import java.util.Arrays;

import com.revature.abstracts.Attractions;
import com.revature.exceptions.NoNegativeException;
import com.revature.interfaces.Visitable;

public class NationalParks extends Attractions implements Serializable, Visitable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String activity;
	private int area;
	private static String typeOfAttraction = "National park";
	private boolean visited;

	public NationalParks() {
		super();
	}

	public NationalParks(String name, String location) {
		super(name, location);
	}

	public NationalParks(String name, String location, String activity, int area) {
		super(name, location);
		this.activity = activity;
		this.area = area;
		System.out.println("New National Park being created");
	}

	public String getActivities() {
		return activity;
	}

	public void setActivities(String activity) {
		this.activity = activity;
	}

	public int getArea() {
		return area;
	}

	/**
	 * Set area If area is < 0 then I will set area to 0
	 * 
	 * @param area
	 * @throws NoNegativeException
	 */
	public void setArea(int area) {
		if (area < 0) {
			this.area = 0;
			throw new NoNegativeException();
		} else {
			this.area = area;
		}
	}

	public static String getTypeOfAttraction() {
		return typeOfAttraction;
	}

	@Override
	public String toString() {
		return "NationalParks [name=" + getName() + " location=" + getLocation() + " activities="
				+ activity + ", area=" + area + "]";
	}

	@Override
	public void visited() {
		System.out.println("You have now visited " + getName() + "!");
		System.out.println("Did you enjoy the park?");
		this.visited = true;
	}

	@Override
	public void whatToDo() {
		System.out.println("Activities at " + getName() + ":");

		System.out.println(activity);

	}

	@Override
	public void printAttractionInfo() {
		System.out.println(
				"Name: " + getName() + "\nLocation: " + getLocation() + "\nArea: " + area + "\nVisited: " + visited);
	}

}
