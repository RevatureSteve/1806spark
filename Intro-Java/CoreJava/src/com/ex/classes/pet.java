package com.ex.classes;

public abstract class pet {

	private String name;
	private int age;
	private boolean isAlive;
	
	public pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public pet(String name, int age, boolean isAlive) {
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
	
	public abstract void speak();
	
}
