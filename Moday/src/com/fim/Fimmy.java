package com.fim;

import java.util.Scanner;

public class Fimmy {
	
	public static void main(String a[]){
		System.out.println("Type in your number!");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] feb = new int[num];
        feb[0] = 0;
        feb[1] = 1;
        for(int i=2; i < num; i++){
            feb[i] = feb[i-1] + feb[i-2];
        }

        for(int i=0; i< num; i++){
                System.out.print(feb[i] + " ");
        }
   }
}
