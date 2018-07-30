package com.revature.pojo;

import java.io.Serializable;

import com.revature.abstracts.Drinks;
import com.revature.exceptions.NoNegativeException;
import com.revature.interfaces.Drinkable;

public class Bottle extends Drinks implements Serializable, Drinkable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 12813029832L;
	private int weight;
	
	
	public Bottle() {
	}
	
	
	public Bottle(String brandName, int ounces, int weight) {
		super(brandName, ounces);
		this.weight = weight;
		System.out.println("New juice is being made");
	}


	public int getWeight() {
		return weight;
	}

	
	/**
	 * Setting int height
	 * 		If height is less then 0 then I will set height to 0
	 * @param height
	 * @throws NoNegativeException
	 */
	public void setWeight(int weight) {
		if (weight < 0) {
			this.weight = 0;
			throw new NoNegativeException();
		} else {
			this.weight = weight;
		}
	}




	@Override
	public String toString() {
		return "Bottle [brand name: " + getBrandName() + " ounces: " + getOunces() + " weight=" + weight + "]";
	}



	@Override
	public void printDrinkInfo() {
		System.out.println(
				"Name: " + getBrandName() + "\nounces: " + getOunces() + "\nweight: " + weight);
	}


	@Override
	public void drank() {
		System.out.println("Drinking some delicious juice");
		
	}



	
	
	
	
	
	
}
