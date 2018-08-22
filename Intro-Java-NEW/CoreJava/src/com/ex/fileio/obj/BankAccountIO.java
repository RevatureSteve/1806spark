package com.ex.fileio.obj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Require exception handling, collections, arrays
 */
public class BankAccountIO {
	public static void main(String[] args) {
		
		String filename = "src/com/ex/fileio/obj/bankAccounts.txt"; //Do you know about classpath?
		
//		writeBankAccounts(filename);
		readBankAccounts(filename);
	}
	
	static void writeBankAccounts(String filename){

		BankAccount john   = new BankAccount(1, "John",   120.50);
		BankAccount amy    = new BankAccount(2, "Amy",    2000);
		BankAccount austin = new BankAccount(3, "Austin", 460.70);
		
		List<BankAccount> accounts = new ArrayList<>();
		accounts.add(john);
		accounts.add(amy);
		accounts.add(austin);
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename));){
			
			for(BankAccount element : accounts){
				bw.write(element.getBankAccountNumber() + ":" + element.getCustomerName() + ":" + element.getBalance() + "\n");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	static void readBankAccounts(String filename){
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename));){
			
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] accountValues = line.split(":");
				System.out.println("Account Number:  " + accountValues[0]);
				System.out.println("Customer Name:   " + accountValues[1]);
				System.out.println("Account Balance: " + accountValues[2]);
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
