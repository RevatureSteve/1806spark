package com.revature.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	/*
	 * boiler plate code
	 */
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	public static Session getSession() {
		return sf.openSession();
		}
	}
