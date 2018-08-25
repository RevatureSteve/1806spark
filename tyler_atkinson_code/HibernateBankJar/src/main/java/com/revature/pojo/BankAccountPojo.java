package com.revature.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BANK_ACCOUNT")
public class BankAccountPojo {
	
	
		@Id
		@Column(name="ACCOUNT_NUMBER")
		private int account_number;
		
		@Column(name="BALANCE")
		private double balance;
		
		@Column(name="USERS_ID")
		private String users_id;
		
		public BankAccountPojo() {}

		public BankAccountPojo(int account_number, double balance, String users_id) {
			super();
			this.account_number = account_number;
			this.balance = balance;
			this.users_id = users_id;
		}

		public int getAccount_number() {
			return account_number;
		}

		public void setAccount_number(int account_number) {
			this.account_number = account_number;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

		public String getUsers_id() {
			return users_id;
		}

		public void setUsers_id(String users_id) {
			this.users_id = users_id;
		}

		@Override
		public String toString() {
			return "BankAccount [account_number=" + account_number + ", balance=" + balance + ", users_id=" + users_id
					+ "]";
		}
		
		
		

	}




