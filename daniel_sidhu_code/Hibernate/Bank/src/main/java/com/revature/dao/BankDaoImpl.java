package com.revature.dao;

import org.hibernate.Session;

import com.revature.Util.HibernateUtil;
import com.revature.domain.BankUser;

public class BankDaoImpl implements BankDao{

	/*
	 * here I get the user from the DB
	 */
	public BankUser getBankUser(int userId) {
		Session session = HibernateUtil.getSession();
		BankUser bU = (BankUser) session.get(BankUser.class, userId);
		session.close();
		return bU;
	}

}
