package com.ex.classes;

public class Launcher {

	public static void main(String[] args) {
		Dog sparky = new Dog("sparky", 48, false, "zombie");
		System.out.println(sparky.getName());
		
		Fish nemo = new Fish("nemo", 13, true, 1);
		System.out.println(nemo.getName());
		
		Dog skippy = new Dog("skippy", 5, true, "husky");
		System.out.println(skippy.getName());
	}
	
	public static void name() {

	}
}
