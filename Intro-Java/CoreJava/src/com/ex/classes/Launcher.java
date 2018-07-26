package com.ex.classes;

public class Launcher {
	public static void main(String[] args) {
<<<<<<< HEAD
		Dog d = new Dog("Sparky", 48, true, "zombie");
		System.out.println(d.getAge());
		Fish johnson = new Fish("johnson", 50, true, 1);
		System.out.println(johnson.getName());
		Bird larry = new Bird("Larry", 2, true, "yellow");
		System.out.println(larry.getColor());
		Pet[] pets = new Pet[3];
		pets[0] = d;
		pets[1] = johnson;
		pets[2] = larry;
		
		for(Pet p: pets) {
			System.out.println(p.getName());
=======
		Dog sparky = new Dog("sparky", 48, false, "zombie");
		Fish johnson = new Fish("johnson", 50, true, 1);
		
		Dog bolt = new Dog("bolt", 3, true, "husky");
		
		Fish bubbles = new Fish("bubbles", 2, true, 4);
		
		Dog drew = new Dog("drew", 8, true, "mut");
		
		Pet[] pets = new Pet[5];
		pets[0] = sparky;
		pets[1] = johnson;
		pets[2] = bolt;
		pets[3] = bubbles;
		pets[4] = drew;
		
		for(Pet p: pets) {
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
			p.speak();
		}
	}
}
