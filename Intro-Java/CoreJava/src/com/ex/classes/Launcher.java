package com.ex.classes;

public class Launcher {
	public static void main(String[] args) {
		Dog d = new Dog("Sparky", 48, true, "zombie");
		System.out.println(d.getAge());
		Fish johnson = new Fish("johnson", 50, true, 1);
		System.out.println(johnson.getName());
		Bird larry = new Bird("Larry", 2, true, "yellow");
		System.out.println(larry.getColor());
		Pet[] pets = new Pet[3];
		pets[0] = d;
		pets[1] = johnson;
		pets[2] = larry;
		
		for(Pet p: pets) {
			System.out.println(p.getName());
			p.speak();
		}
	}
}
