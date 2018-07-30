package com.revature.pojo;

import java.io.Serializable;

import com.revature.abstracts.Drinks;
import com.revature.exceptions.NoNegativeException;
import com.revature.interfaces.Drinkable;

public class Can extends Drinks implements Serializable, Drinkable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 128130298321L;
	private int weight;

	public Can() {
		super();
	}


	public Can(String brandName, int ounces, int weight) {
		super(brandName, ounces);
		this.weight = weight;
		System.out.println("New soda is being made");
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if (weight < 0) {
			this.weight = 0;
			throw new NoNegativeException();
		} else {
			this.weight = weight;
		}
	}


	/**
	 * Set weight if weight is < 0 then I will set weight to 12
	 * 
	 * @param area
	 * @throws NoNegativeException
	 */



	@Override
	public String toString() {
		return "Can [brand name: " + getBrandName() + " ounces: " + getOunces() + " weight=" + weight + "]";
	}

	@Override
	public void printDrinkInfo() {
		System.out.println(
				"Name: " + getBrandName() + "\nounces: " + getOunces() + "\nweight: " + weight);
	}


	@Override
	public void drank() {
		System.out.println("You drank a refreshing " + getBrandName());
	}

	
}
