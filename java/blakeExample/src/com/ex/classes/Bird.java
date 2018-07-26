package com.ex.classes;

public class Bird extends Pet{
	private String breed;
	
	public Bird() {
	super();
	
	 // TODO Auto-generated constructor stub
	 }
/**
 * @param name
 * @param age
 * @param isAlive
 */
public Bird(String name, int age, boolean isAlive, String breed) {
    super(name, age, isAlive);
    this.breed = breed;
}

public String getBreed() {
    return breed;
}

public void setBreed(String breed) {
    this.breed = breed;
}

}
