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
		
	}
}
