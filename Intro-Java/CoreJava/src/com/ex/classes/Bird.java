package com.ex.classes;

public class Bird extends Pet{
	private int numberFeathers;
	public Bird() {
		super();
		// TODO Auto-generated constructor stub
	
	}
	public Bird(String name, int age, boolean isAlive) {
		super(name, age, isAlive);
		// TODO Auto-generated constructor stub
	}
	public int getNumberFeathers() {
		return numberFeathers;
	}
	public void setNumberFeathers(int numberFeathers) {
		this.numberFeathers = numberFeathers;
	}
	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println(this.getName() + " chirps" );
		
	}
	
	
	
	

}
