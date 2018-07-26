package com.revature.animals;

public class Animal {

	public String altPairs(String str) {
		  String temp = "";
		  for(int i = 0; i < str.length(); i++){
		    temp = temp + str.substring(i, i+1);
		    if(i%2 == 1){
		      i=i+2;
		    }
		  }
		  return temp;
		}
	
	public boolean has271(int[] nums) {
		  
		  for(int i = 0; i < nums.length-2; i++){
		    int first = nums[i];
		    int i1 = nums[i+1];
		    int i2 = Math.abs(first-nums[i+2]);
		    if(nums[i+1] == first + 5 && Math.abs(first-1-nums[i+2]) < 2){
		      return true;
		    }
		  }
		  return false;
		}



	public String name;
	
	public void eat() {
		System.out.println("Animal eats");
	}
	
}
