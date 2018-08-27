package com.revature.pojos;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Driver {
	static SessionFactory sf;
	

	public static void main(String[] args) throws InterruptedException {
		
		Driver dr = new Driver();
			
			sf = dr.createSessionFactory();
		
		
	}
	
	public SessionFactory createSessionFactory(){
    	sf =
        		new Configuration().
        		configure().
        		buildSessionFactory();
        System.out.println("Built Session Factory");
        return sf;
    }

}
