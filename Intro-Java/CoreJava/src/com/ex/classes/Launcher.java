package com.ex.classes;

public class Launcher {
	public static void main(String[] args) {
		Dog sparky = new Dog("sparky", 48, false, "zombie");
		System.out.println(sparky.getName());
		Fish johnson = new Fish("johnson", 50, true, 1);
		System.out.println(johnson.getName());
	}
}
