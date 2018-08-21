package com.revature.abstracts;

import java.io.Serializable;

import com.revature.interfaces.LikeCupcakes;

public abstract class MathTeam implements Serializable, LikeCupcakes{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7587198893489651873L;
	private int a;
	private int b;
	
	
	/**
	 * 
	 */
	public MathTeam() {
		super();
	}

	/**
	 * @param a
	 * @param b
	 */
	public MathTeam(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public int add() {
		return a+b;
	}
	
	public int multiply() {
		return a*b;
	}
	
	//abstract methods
	public abstract int subtract() throws Exception;
	
	public abstract int divide() throws RuntimeException;
	
	//getters and setters
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "MathTeam [a=" + a + ", b=" + b + "]";
	}

	
}
