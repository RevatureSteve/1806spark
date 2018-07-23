package com.ex.flowcontrol;

/*
 * FOR VS WHILE LOOPS
 * 
 * for loops are typically used when you KNOW the number of iterations
 * 
 * while loops are typically used when you DON'T KNOW the number of iterations
 */
public class WhileDoWhileLoops {
	public static void main(String[] args) {
/*		
		boolean running = true;
		while(running){
			System.out.println("infinite loop");
		}
*/		
		
		
		int i = 20;
		
		/*
		 * WHILE LOOP
		 * 
		 * checks condition BEFORE running loop content
		 */
		while(i < 15){
			System.out.println("while");
		}
		
		/*
		 * DO-WHILE LOOP
		 * 
		 * checks condition AFTER running loop content
		 * 
		 * NOTE: use if you want your loop to run AT LEAST ONCE
		 */
		do{
			System.out.println("do while");
		}while(i < 15);		

		
	}
}
