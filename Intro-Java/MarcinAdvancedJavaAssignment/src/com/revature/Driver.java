package com.revature;

import java.util.Scanner;

import com.revature.io.IOHandler;

public class Driver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		IOHandler.getInputs(scan);
		scan.close();
	}
}
