package com.revature.mapping;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="users")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Cacheable	
public class BankUser {

		@Id
		@Column(name="users_id")
		@SequenceGenerator(sequenceName="new_id", name="new_id")
		@GeneratedValue(generator="new_id",
				strategy=GenerationType.SEQUENCE)
		private int userId;
		
		
		@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
		private Set<BankAccount> ba = new HashSet<BankAccount>();
		
		
		
		@Column(name="username")
		private String username;
		
		@Column(name="password")
		private String password;
		
		@Column(name="fname")
		private String fname;
		
		@Column(name="lname")
		private String lname;

		public BankUser() {
			super();
			// TODO Auto-generated constructor stub
		}

		public BankUser(int userId, Set<BankAccount> ba, String username, String password, String fname, String lname) {
			super();
			this.userId = userId;
			this.ba = ba;
			this.username = username;
			this.password = password;
			this.fname = fname;
			this.lname = lname;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public Set<BankAccount> getBa() {
			return ba;
		}

		public void setBa(Set<BankAccount> ba) {
			this.ba = ba;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getLname() {
			return lname;
		}

		public void setLname(String lname) {
			this.lname = lname;
		}

		@Override
		public String toString() {
			return "BankUser [userId=" + userId + ", username=" + username + ", password=" + password
					+ ", fname=" + fname + ", lname=" + lname + "]";
		}
		
		
		
}
