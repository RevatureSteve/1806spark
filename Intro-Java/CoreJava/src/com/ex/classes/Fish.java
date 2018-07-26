package com.ex.classes;

public class Fish extends Pet {
	private int numberFins;
<<<<<<< HEAD
	
=======

>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
	public Fish() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fish(String name, int age, boolean isAlive, int numberFins) {
		super(name, age, isAlive);
		this.numberFins = numberFins;
	}

<<<<<<< HEAD
	public int getnumberFins() {
		return numberFins;
	}

	public void setnumberFins(int numberFins) {
		this.numberFins = numberFins;
	}
	
=======
	public int getNumberFins() {
		return numberFins;
	}

	public void setNumberFins(int numberFins) {
		this.numberFins = numberFins;
	}

>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
	@Override
	public void speak() {
		System.out.println(this.getName() + " bubbles");
	}
<<<<<<< HEAD
	
=======

>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
}
