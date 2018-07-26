package com.ex.classes;

public class Launcher {
<<<<<<< HEAD

	public static void main(String[] args) {
		Dog sparky = new Dog("sparky", 48, false, "zombie");
		//System.out.println(sparky.getName());
		
		Fish nemo = new Fish("nemo", 13, true, 1);
		//System.out.println(nemo.getName());
		
		Dog skippy = new Dog("skippy", 5, true, "husky");
		//System.out.println(skippy.getName());
		
		Bird tucan = new Bird("tucan", 6, true);
		//System.out.println(tucan.getName());
		
		Fish carl = new Fish("carl", 3, true, 1);
		//System.out.println(carl.getName());
		
		Pet[] pet = new Pet[5];
		pet[0] = sparky;
		pet[1] = nemo;
		pet[2] = skippy;
		pet[3] = tucan;
		pet[4] = carl;
		
		//advanced FOR loop syntax
		for(Pet p: pet) {
			System.out.println(p.getName());
		}
	}
	
		
=======
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
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
}
