package com.ex.arrays;

public class ArrayTraversal {
	public static void main(String[] args) {
		int[][] intArr2D_4 = {{1},{2,3},{4,5,6},{7,8,9,0}};	//Instantiate and Populate array in one line
		
		for(int i = 0; i < intArr2D_4.length; i++){
			for(int j = 0; j < intArr2D_4[i].length; j++){
				System.out.print(intArr2D_4[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
