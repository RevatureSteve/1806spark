package com.revature;

public class Driver {
	
	public static void main(String[] args) {
		System.out.println("Cats...");
		Cat kittyCat = new Cat("Kitty Cat", "mainecoon");
		Cat catdog = new Cat();
		catdog.setName("Cat-Dog");
		catdog.setBreed("not cat not dog");
		catdog.age = 10;
		
		takeCat(kittyCat);
		takeCat(catdog);
	}

	public static void takeCat(Cat cat) {
		System.out.println("My cat argument " + cat);
		System.out.println("also the age: " + cat.age);
	}
}
