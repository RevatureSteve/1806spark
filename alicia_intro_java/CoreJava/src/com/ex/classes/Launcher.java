package com.ex.classes;

public class Launcher {
	
	public static void main(String[] args) {
		Dog sparky = new Dog("sparky", 48, false, "zombie");
		System.out.println(sparky.getName());
		System.out.println();
		
		
		Fish johnson = new Fish("Johnson", 50, true, 1);
		System.out.println(johnson.getName());
		
		Pet yukon = new Dog("Yukon", 18, false, "Australian Shepard");
		Pet blue = new Fish("Blue", 13, true, 3);
		Pet wing = new Bird("Wing", 56, true);
		Pet roxy = new Dog("Roxy", 6, true, "mutt");
		Pet sparkle = new Bird("Sparkle", 63, false);
		
		Pet[] petArray = {yukon, blue, wing, roxy, sparkle};
		
		for (Pet p : petArray) {
			p.speak();
		}
		
	}
}
