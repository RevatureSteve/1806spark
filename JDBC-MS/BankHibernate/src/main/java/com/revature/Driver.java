package com.revature;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.revature.domain.BankUser;

public class Driver {
	static SessionFactory sessionFactory;
	public static void main(String[] args) {
		Driver app = new Driver();
		sessionFactory = app.createSessionFactory();
		
		app.getUser();
		

	}
	private void getUser() {
		Session session = sessionFactory.openSession();
    	System.out.println("--------------Load Bear-----------\n");
    	BankUser userget = (BankUser) session.get(BankUser.class, 1);
    	System.out.println("Loading user: " + userget.toString() + "\n");
    	System.out.println(userget.getClass());
    	session.close();
    	System.out.println("Loading user: " + userget.toString());
	}
	
	public SessionFactory createSessionFactory(){
    	sessionFactory =
        		new Configuration().
        		configure().
        		buildSessionFactory();
        System.out.println("Built Session Factory");
        return sessionFactory;
    }
}
