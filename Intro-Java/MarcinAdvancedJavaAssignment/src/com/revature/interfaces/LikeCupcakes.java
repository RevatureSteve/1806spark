package com.revature.interfaces;

public interface LikeCupcakes {
	int allCupcakes = 100000;
	boolean likesCupcakes();
	
	default String returnString() {
		return "hello";
	}
}
