package com.ex.arrays;

import java.util.Arrays;

public class ArrayManipulation {
	public static void main(String[] args) {
		
		int[] intArr = new int[5];
		System.out.println(intArr[0]); //Arrays are base 0
		System.out.println(intArr[4]); //This is the last index
//		System.out.println(intArr[5]); //ArrayIndexOutOfBoundsException
		
		intArr[0] = 7;
		intArr[1] = 9;
		intArr[2] = 1000;
		intArr[3] = 25;
		intArr[4] = 9;
//		intArr[-1] = 3; //ArrayIndexOutOfBoundsException
//		intArr[5] = 3; //ArrayIndexOutOfBoundsException
		
		/*
		 * Let's print out the array
		 */
		System.out.println(intArr); 		//Prints out: type @ hashcode
		System.out.println(new Object());	//Prints out: type @ hashcode
		
		
		
		/*
		 * Arrays is a 'Utility Class' (notice the 's')
		 * 		Utility classes typically have many helpful static methods
		 * 
		 * sort
		 * binarySearch (the array must be sorted first)
		 * asList
		 * copyOf
		 * 
		 * toString (overridden from Object class)
		 * equals   (overridden from Object class)
		 * 
		 */
		System.out.println(Arrays.toString(intArr));
		Arrays.sort(intArr);
		System.out.println(Arrays.toString(intArr));
		
		System.out.println(Arrays.binarySearch(intArr, 25)); //returns index of element
		System.out.println(Arrays.binarySearch(intArr, 2));  //returns -1 if not found
		
	}
}
