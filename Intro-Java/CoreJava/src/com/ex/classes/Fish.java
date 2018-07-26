package com.ex.classes;

public class Fish extends Pet {
<<<<<<< HEAD
	
=======
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
	private int numberFins;

	public Fish() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fish(String name, int age, boolean isAlive, int numberFins) {
		super(name, age, isAlive);
		this.numberFins = numberFins;
<<<<<<< HEAD
		// TODO Auto-generated constructor stub
	}
	
=======
	}
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146

	public int getNumberFins() {
		return numberFins;
	}

	public void setNumberFins(int numberFins) {
		this.numberFins = numberFins;
<<<<<<< HEAD
	}	
	
	@Override
	public void speak() {
		System.out.println(this.getName() + " meep");
	}
=======
	}

	@Override
	public void speak() {
		System.out.println(this.getName() + " bubbles");
	}

>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
}
