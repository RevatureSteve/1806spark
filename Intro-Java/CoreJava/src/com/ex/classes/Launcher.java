package com.ex.classes;

public class Launcher {
	public static void main(String[] args) {
		Dog sparky = new Dog("Sparky", 48, false, "zombie");
//		System.out.println(sparky.getName());
//		System.out.println(sparky.name);
		
		Fish johnson = new Fish("johnson", 50, true, 1);
		Bird pete = new Bird("pete", 100, true);
//		System.out.println(johnson.getName());
		
		
	Pet[] petArray = {sparky, johnson, pete};
		
		for (Pet element: petArray) {
			element.speak();
		}
		
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
			p.speak();
		}
	}
}
