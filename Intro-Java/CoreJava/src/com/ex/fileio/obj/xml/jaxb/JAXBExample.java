package com.ex.fileio.obj.xml.jaxb;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBExample {
	public static void main(String[] args) {
		
		String filename = "src/com/ex/fileio/obj/xml/jaxb/bankAccounts.xml";

		
		BankAccount john   = new BankAccount(1, "John",   120.50);
		BankAccount amy    = new BankAccount(2, "Amy",    2000);
		BankAccount austin = new BankAccount(3, "Austin", 460.70);
		
		List<BankAccount> accounts = new ArrayList<>();
		accounts.add(john);
		accounts.add(amy);
		accounts.add(austin);
		
		Bank bank = new Bank("My First Bank", accounts);
		
//		write(bank, filename);
		read(filename);
		
		
		
	}
	
	static void read(String filename){
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Bank.class);
			
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			
			Bank bank = (Bank) unmarshaller.unmarshal(new File(filename));
//			System.out.println(bank);
			for(BankAccount account : bank.getBankAccounts()){
				System.out.println(account);
			}
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	static void write(Bank bank, String filename){
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Bank.class);
			
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			marshaller.marshal(bank, new File(filename));
		
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
