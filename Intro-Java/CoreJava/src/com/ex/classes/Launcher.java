package com.ex.classes;

public class Launcher {
	
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
}
