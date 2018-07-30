package com.revature.calculate;

import java.util.Scanner;


public class Cal {

	public static void main(String[] args) {
		Scanner dan = new Scanner(System.in);
		double firstNumber, secondNumber, answer;
		
		System.out.println("Welcome to my Interactive Calculator!");
		System.out.println("--enter first number--");
		firstNumber = dan.nextDouble();
		System.out.println("--enter second number--");
		secondNumber = dan.nextDouble();
		answer = firstNumber + secondNumber;
		
		System.out.println(answer);
		
	}
}
