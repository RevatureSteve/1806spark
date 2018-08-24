package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.pojo.taskPojo;
import com.revature.util.HibernateUtil;

public class TodoDaoImpl implements TodoDao {

	public void createTask(taskPojo tp) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(tp);
		tx.commit();
		session.close();
		
		
	}

	public taskPojo getTaskById(int id) {
		
		Session session = HibernateUtil.getSession();
		taskPojo tp = (taskPojo) session.get(taskPojo.class, id);
		session.close();
		
		
		return tp;	
	}
	
	

	
}
