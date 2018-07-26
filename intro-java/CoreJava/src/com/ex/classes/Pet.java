package com.ex.classes;

public abstract class Pet {
	private String name;
    private int age;
    private boolean isAlive;
    
    
	public Pet() {
		super();
		
	}
	public Pet(String name, int age, boolean isAlive) {
		super();
		this.name = name;
		this.age = age;
		this.isAlive = isAlive;
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
	}
    
     public abstract void speak(); // any class that extends this class, must implement this method. Abstract method is a method with no body but implements it's extended classes 
}
