package com.revature.dao;

import com.revature.util.HibernateUtil;

import org.hibernate.Session;

import com.revature.domain.BankUser;

public class DaoImpl implements DaoInterface {

	@Override
	public void getUserTxAndType(int id) {
		Session session = HibernateUtil.getSession();
		BankUser user = (BankUser) session.get(BankUser.class, id);
		session.close();
	}
	
}
