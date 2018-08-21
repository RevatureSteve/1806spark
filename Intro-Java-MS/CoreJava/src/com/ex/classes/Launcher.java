package com.ex.classes;

public class Launcher {
	public static void main(String[] args) {
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
			p.speak();
		}
	}
}
