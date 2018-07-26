package com.revature.rooms;

import com.revature.abstracts.Room;

public class DarkRoom extends Room {

	private boolean doorsLocked;
	private int numberOfWeapons;
	public String name;

	/**
	 * 
	 */
	public DarkRoom() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numberOfDoors
	 * @param numberOfPeople
	 * @param numberOfLions
	 */
	public DarkRoom(int numberOfDoors, int numberOfPeople, int numberOfLions, boolean doorsLocked) {
		super(numberOfDoors, numberOfPeople, numberOfLions);
		this.doorsLocked = doorsLocked;
		// TODO Auto-generated constructor stub
	}
	
	//behavior
	public void turnKey() {
		System.out.println("*Click!*");
		doorsLocked= !doorsLocked;
	}

	@Override
	public void releaseLions() {
		
		if (doorsLocked) {
			this.setNumberOfPeople(0);
		} else if(this.getNumberOfPeople()>this.getNumberOfLions()){
			this.setNumberOfPeople(this.getNumberOfPeople() - this.getNumberOfLions());
		} else {
			this.setNumberOfPeople(0);
		}
		System.out.println("Number of people left: " + this.getNumberOfPeople());
	}

	@Override
	public String toString() {
		return super.toString() + "DarkRoom [doorsLocked=" + doorsLocked + ", numberOfWeapons=" + numberOfWeapons + ", name=" + name + "]";
	}
	
	
}
