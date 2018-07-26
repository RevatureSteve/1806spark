package com.revature;

public class Driver {

	
	public static void main(String[] args) {
		System.out.println("Cats...");
		Cat kittyCat = new Cat("Kitty Cat", "mainecoon");
		kittyCat.age = 20;
		Cat catDog = new Cat(); 
		catDog.setName("Cat-Dog");
		catDog.setBreed("not mainecoon");
		catDog.age = 10; // age is public while name & breed are private!
		
		takeCat(kittyCat);
		takeCat(catDog);
	}
	
	public static void takeCat(Cat cat) {
		System.out.println("My cat argument: " + cat);
		System.out.println("also the age: " + cat.age);
		
	}
}
