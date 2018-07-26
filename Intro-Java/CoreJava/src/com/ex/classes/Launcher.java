package com.ex.classes;

public class Launcher {
	
	public static void main(String[] args) {
		//String s = "hello";
		Dog sparky = new Dog("sparky", 48, false, "zombie");

		Fish johnson = new Fish("johnson", 50, true, 1);

		Bird travis = new Bird("travis", 22, true);

		Dog herc = new Dog("herc", 15, true, "lab");

		Fish chad = new Fish("chad", 0, true, 1);

		Pet[] petArray = { sparky, johnson, travis, herc, chad };

		for (Pet p : petArray) {
			p.speak();
		}
	}
}