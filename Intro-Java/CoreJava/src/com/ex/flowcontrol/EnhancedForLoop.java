package com.ex.flowcontrol;

/*
 * a foreach loop works the same as a for loop, however...
 * 
 * foreach cannot modify data as it's looping. (very important!!)
 * 		- ConcurrentModificationException
 * 
 * foreach actually is converted into an Iterator behind the scenes (very important!!)
 * 
 */
public class EnhancedForLoop {
	public static void main(String[] args) {
		
		int[] intArray = new int[5];
		intArray[0] = 10;
		intArray[1] = 11;
		intArray[2] = 12;
		intArray[3] = 13;
		intArray[4] = 14;
		
		/*
		 * for loop
		 */
		for(int i = 0; i < intArray.length; i++){
			System.out.println(intArray[i]);
		}

		
		System.out.println();
		
		
		/*
		 * enhanced for loop (for each loop)
		 */
		for(int element: intArray){
			System.out.println(element);
		}
		
	}
}
