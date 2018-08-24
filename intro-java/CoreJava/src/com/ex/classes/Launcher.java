package com.ex.classes;

public class Launcher {
	public static void main(String[] args) {
		Pet[] petArr = new Pet [5];
		petArr[0] = new Dog("growlithe", 22, false, "fire puppy");
		petArr[1] = new Bird("Yuko", 605, true, "Phoenix", true);
		petArr[2] = new Fish("Goldeen", 15, true, 2);
		petArr[3] = new Dog("Cerberus", 9999, false, "Hellhound");
		petArr[4] = new Bird("Azure", 605, true, "Water Bird", true);
		
		for(Pet p: petArr){
		    p.speak();
		}
	}
}