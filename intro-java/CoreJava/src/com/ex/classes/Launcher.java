package com.ex.classes;

public class Launcher {
    public static void main(String[] args) {
    	Dog sparky = new Dog("sparky", 48, false, "zombie");
        Fish johnson = new Fish("johnson", 50, true, 1);
    	Bird chewy = new Bird("chewy", 12, true, "parrot");
    	Dog jojo = new Dog("jojo", 3, true, "husky");
    	Fish nemo = new Fish("nemo", 7, false, 5);
    	
    	
    	Pet[] pets = new Pet[5];
    	pets[0] = sparky;
    	pets[1] = johnson;
    	pets[2] = chewy;
    	pets[3] = jojo;
    	pets[4] = nemo;
    	
    	for(Pet p: pets) {
    		p.speak();
    	}
    	
    	
    }
}
