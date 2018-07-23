package com.ex.arrays;

/*
 * When defining arrays, you must define the type and size
 * 
 * NOTE: arrays are objects
 */
public class DefineArrays {
	public static void main(String[] args) {
		
		/*
		 * 1D arrays
		 */
		int[] intArr1D_1 = new int[5];
		intArr1D_1[0] = 10;
		intArr1D_1[1] = 50;
		intArr1D_1[2] = 100;
		
		int intArr1D_2[] = new int[5];	// same as line 14
		int[] intArr1D_3 = {4,3,2,1};	//Instantiate and Populate array in one line
		
		/*
		 * 2D arrays
		 */
		int[][] intArr2D_1 = new int[5][2];
		int intArr2D_2[][] = new int[5][2];
		int[] intArr2D_3[] = new int[5][2];
		int[][] intArr2D_4 = { {1},{2,3},{4,5,6},{7,8,9,0} };	//Instantiate and Populate array in one line
		
		
		
		/*
		 * 3D arrays
		 */
		int[][][] intArr3D = new int[1][1][1];
		
		/*
		 * 4D and so on...
		 */
	}
}
