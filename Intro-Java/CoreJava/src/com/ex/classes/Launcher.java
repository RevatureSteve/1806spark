package com.ex.classes;

public class Launcher {
<<<<<<< HEAD
	
public static void main (String[] args) {
	Dog sparky = new Dog ("Sparky", 48, false, "zombie");
//	System.out.println(sparky.getName());
	
	Fish johnson = new Fish ("Johnson" , 45 , true , "twelve");
//	System.out.println(johnson.isAlive());
	
	Fish billy = new Fish ("Billy" , 45 , true , "twelve");
//	System.out.println(johnson.isAlive());
	
pet[] petArray = {sparky, johnson, billy};
	
	for(pet element: petArray) {
		System.out.println(element.getName());
		element.speak();
//		for(pet p: petArray{
//		System.out.println(p.getName());
//	}
		
//		for(int i = 0; i < petArray.length; i++){
//		System.out.println(petArray[i].getName());
//		}
		
		

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
