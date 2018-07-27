package com.revature;

import java.util.Scanner;

import com.revature.abstracts.LabelA;
import com.revature.classes.LabelABext;
import com.revature.classes.LabelBAext;

public class Driver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Insert a number");
		int x = scan.nextInt();
		System.out.println("Insert A");
		int a = scan.nextInt();
		System.out.println("Insert B");
		int b = scan.nextInt();
		scan.close();
		LabelABext ab = new LabelABext(0, x, a, b);
		LabelBAext ba = new LabelBAext(x, a, b);
		
		FileSerialization.serialize(ab);
		LabelA fromFile = FileSerialization.deserialize("file1.ser");
		System.out.println(fromFile.toString()); 
	}

}
