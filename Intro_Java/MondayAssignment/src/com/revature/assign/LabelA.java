package com.revature.assign;



/**
 * 
 * @author Eddie
 *
 *		Create an abstract class LABEL A: 
 *      	-with 2 properties 
 *         	-with 3 methods, at least 1 concrete, 1 abstract
 *
 */

public abstract class LabelA {

	/**
	 *
	 * 2 properties
	 */
	private int age;
	private int aggro;

	public LabelA() {
		super();
	}

	public LabelA(int age, int aggro) {
		super();
		this.age = age;
		this.aggro = aggro;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAggro() {
		return aggro;
	}

	public void setAggro(int aggro) {
		this.aggro = aggro;
	}

	/*
	 * Abstract method
	 */
	public abstract void evolve();

	/*
	 * Concrete method
	 */
	public void getPotential() {

	}

	@Override
	public String toString() {
		return "LabelA [age=" + age + ", aggro=" + aggro + "]";
	}

}
