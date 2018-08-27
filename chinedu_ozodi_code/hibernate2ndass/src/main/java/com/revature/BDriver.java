package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.revature.domain.BankAccount;
import com.revature.domain.BankTx;
import com.revature.domain.BankUser;

public class BDriver {
	
	static SessionFactory sessionFactory;

	public BDriver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		sessionFactory = 
    			BDriver.createSessionFactory();
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
//        BankUser user = new BankUser(6,"Name","LastName", "uname","password");
//        session.save(user);
//        System.out.println("saved user " + user);
        // Roaming bears looking for place to hibernate
        BankUser user = (BankUser) session.get(BankUser.class, 1000);
//        BankAccount ba = new BankAccount(user,1230,0);
//        session.save(ba);     
      BankAccount ba = (BankAccount) session.get(BankAccount.class, 1230);
      System.out.println("Bank account" + ba);
//      session.save(ba);     
        System.out.println(user);
        System.out.println(user.getBankAccounts());
//        BankAccount account = (BankAccount) session.get(BankAccount.class, 1);
//        System.out.println("Bank account " + account);
//        BankTx btx = (BankTx) session.get(BankTx.class, 1);
//        System.out.println("Bank tx " + btx);
        tx.commit();
        session.close();
	}
	
	public static SessionFactory createSessionFactory(){
    	sessionFactory =
        		new Configuration().
        		configure().
        		buildSessionFactory();
        System.out.println("Built Session Factory");
        return sessionFactory;
    }

}
