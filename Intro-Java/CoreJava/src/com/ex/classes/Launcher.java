package com.ex.classes;

public class Launcher {

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
	
		
}
