package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.pojo.Task;
import com.revature.util.HibernateUtil;

public class TodoDaoImpl implements TodoDao{

	/*
	 * here I am getting the task by Id
	 */
	public Task getTaskById(int id) {
		Session session = HibernateUtil.getSession();
		Task task = (Task) session.get(Task.class, id);
		session.close();
		return task;
	}

	/*
	 * here I am creating the new task
	 */
	public void createTask(Task task) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(task);
		tx.commit();
		session.close();
	}
	
	
	

}
