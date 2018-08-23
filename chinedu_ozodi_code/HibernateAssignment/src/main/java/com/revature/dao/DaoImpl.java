package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.Task;
import com.revature.domain.User;
import com.revature.util.HibernateUtil;

public class DaoImpl implements Dao {

	public DaoImpl() {

	}

	public void createTask(Task t) {

		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(t); // save = insert in hibernate
		tx.commit();
		session.close();
	}

	public Task getTaskById(int id) {

		Session session = HibernateUtil.getSession();
		Task t = (Task) session.get(Task.class, id);
		session.close();
		return t;
	}
	
	public void createUser(User user) {

		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(user); // save = insert in hibernate
		tx.commit();
		session.close();
	}
}
