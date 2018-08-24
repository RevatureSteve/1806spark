package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.mapping.BankUser;

public class Driver {

	static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		Driver driver = new Driver();
		sessionFactory = driver.createSessionFactory();
		driver.getUser();
		
	}
	
	public SessionFactory createSessionFactory() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		return sessionFactory;
	}
	
	
	public void getUser() {
		Session session = sessionFactory.openSession();
		
		BankUser user = (BankUser) session.get(BankUser.class, 2);
		session.close();
		System.out.println(user.toString());
	}

}
