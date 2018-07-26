package com.ex.classes;

public class Launcher {
	public static void main(String[] args) {
		
		Pet[] pets = new Pet[3];
	
		
		Dog sparky = new Dog("sparky", 48, false, "zombie");
		Fish johnson = new Fish("johnson", 50, true, 1);
		Bird polly = new Bird("polly", 2, true, 2);
				
				
		pets[0] = sparky;
		pets[1] = johnson;
		pets[2] = polly;
		
				for(Pet element: pets) {
					element.speak();
				}
	}
}
