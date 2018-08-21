/**
 * 
 */
package com.revature.abstracts;

import com.revature.exceptions.TooFewLionsException;
import com.revature.exceptions.TooFewPeople;

/**
 * @author marci
 *
 */
public abstract class Room {
	private int numberOfDoors;
	private int numberOfPeople;
	private int numberOfLions;
	/**
	 * NO-ARGS Constructor
	 */
	public Room() {}
	

	/**
	 * @param numberOfDoors
	 * @param numberOfPeople
	 * @param numberOfLions
	 */
	public Room(int numberOfDoors, int numberOfPeople, int numberOfLions) {
		super();
		this.numberOfDoors = numberOfDoors;
		this.numberOfPeople = numberOfPeople;
		this.numberOfLions = numberOfLions;
	}

	//behavior abstract
	public abstract void releaseLions();
	
	public int getNumberOfDoors() {
		return numberOfDoors;
	}

	//getters and setters
	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople){
		if(numberOfPeople < 0) {
			throw new TooFewPeople();
		}
		this.numberOfPeople = numberOfPeople;
	}

	public int getNumberOfLions() {
		return numberOfLions;
	}
	
	public void setNumberOfLions(int numberOfLions) throws TooFewLionsException {
		if(numberOfLions<0) {
			throw new TooFewLionsException(numberOfLions);
		}
		this.numberOfLions = numberOfLions;
	}

	@Override
	public String toString() {
		return "Room [numberOfDoors=" + numberOfDoors + ", numberOfPeople=" + numberOfPeople + ", numberOfLions="
				+ numberOfLions + "]";
	}
}
