package com.revature.pojo;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class Driver {

	
	static SessionFactory sessionFactory;
	
	public static void main(String[] args) throws InterruptedException {
		
		
	
	        Driver driver = new Driver();
	    	sessionFactory = 
	    			driver.createSessionFactory();
	    	
	    	criteriaDemo();
	    	
	}
	    	
	    
	    public SessionFactory createSessionFactory(){
	    	sessionFactory =
	        		new Configuration().
	        		configure().
	        		buildSessionFactory();
	        System.out.println("Built Session Factory");
	        return sessionFactory;
	    }


	    public static void criteriaDemo(){
	    	Session session = sessionFactory.openSession();
	    	Criteria criteria;
	    	
	    	System.out.println("*-----List all Bank Accounts-----*");
	    	List<BankAccountPojo> bankAccounts = session.createCriteria(BankAccountPojo.class).list();
	    	for(Object balance : bankAccounts ){
	    		balance = (List<BankAccountPojo>) bankAccounts;
	    		System.out.println(balance);
	    	}

	    	

	    }
	    
}

