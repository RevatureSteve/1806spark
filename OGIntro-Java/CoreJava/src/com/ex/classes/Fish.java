package com.ex.classes;

public class Fish extends Pet {
<<<<<<< HEAD
	private String name;
	private int age;
	private boolean isAlive;
	private int numberFins;
	
=======
	private int numberFins;

>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
	public Fish() {
		super();
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
	public Fish(String string, int i, boolean b, int j) {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
=======
	public Fish(String name, int age, boolean isAlive, int numberFins) {
		super(name, age, isAlive);
		this.numberFins = numberFins;
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
	}

	public int getNumberFins() {
		return numberFins;
	}

	public void setNumberFins(int numberFins) {
		this.numberFins = numberFins;
	}

	@Override
	public void speak() {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		System.out.println(this.getName() + " bubbles");
	}

	

	
	
	
	
}
=======
		System.out.println(this.getName() + " bubbles");
	}

}
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
