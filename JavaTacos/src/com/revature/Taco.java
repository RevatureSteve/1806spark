package com.revature;

public class Taco {
	
	private String tacoName;
	public boolean cheese;
	private int numOfToppings;
	
	public Taco() {
		super();
	}

	public Taco(String tacoName, boolean cheese, int numOfToppings) {
		super();
		this.tacoName = tacoName;
		this.cheese = cheese;
		this.numOfToppings = numOfToppings;
	}

	public String getTacoName() {
		return tacoName;
	}

	public void setTacoName(String tacoName) {
		this.tacoName = tacoName;
	}

	public boolean isCheese() {
		return cheese;
	}

	public void setCheese(boolean cheese) {
		this.cheese = cheese;
	}

	public int getNumOfToppings() {
		return numOfToppings;
	}

	public void setNumOfToppings(int numOfToppings) {
		this.numOfToppings = numOfToppings;
	}

	@Override
	public String toString() {
		return "Taco [tacoName=" + tacoName + ", cheese=" + cheese + ", numOfToppings=" + numOfToppings + "]";
	}
	
	
	
	
	
	
	
}
