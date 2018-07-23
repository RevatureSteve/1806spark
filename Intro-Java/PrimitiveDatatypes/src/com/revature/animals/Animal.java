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
		
}
