<<<<<<< HEAD
/*
 * @author Marcin Salamon
 */
package com.ex.classes;

public class Fish extends Pet{
	
	private int numFins;

	/**
	 * 
	 */
=======
package com.ex.classes;

public class Fish extends Pet {
	private int numberFins;

>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
	public Fish() {
		super();
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
	/**
	 * @param name
	 * @param age
	 * @param isAlive
	 */
	public Fish(String name, int age, boolean isAlive, int numFins) {
		super(name, age, isAlive);
		this.numFins = numFins;
		// TODO Auto-generated constructor stub
	}

	public int getNumFins() {
		return numFins;
	}

	public void setNumFins(int numFins) {
		this.numFins = numFins;
=======
	public Fish(String name, int age, boolean isAlive, int numberFins) {
		super(name, age, isAlive);
		this.numberFins = numberFins;
	}

	public int getNumberFins() {
		return numberFins;
	}

	public void setNumberFins(int numberFins) {
		this.numberFins = numberFins;
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
	}

	@Override
	public void speak() {
<<<<<<< HEAD
		System.out.println("Blub Blub");
	}
	
	
=======
		System.out.println(this.getName() + " bubbles");
	}
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146

}
