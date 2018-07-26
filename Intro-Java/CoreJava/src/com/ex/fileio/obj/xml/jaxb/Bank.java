package com.ex.fileio.obj.xml.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bank {
	
	private String name;
	private List<BankAccount> bankAccounts;
	
	public Bank(){}

	public Bank(String name, List<BankAccount> bankAccounts) {
		super();
		this.name = name;
		this.bankAccounts = bankAccounts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	@Override
	public String toString() {
		return "Bank [name=" + name + ", bankAccounts=" + bankAccounts + "]";
	}
	
	
}
