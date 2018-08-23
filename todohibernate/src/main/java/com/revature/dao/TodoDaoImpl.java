package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.Todo;
import com.revature.util.HibernateUtil;

public class TodoDaoImpl implements TodoDao {

	public void createTodo(Todo todo) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(todo);
		tx.commit();
		session.close();
	}

	public Todo getTodoById(int id) {
		Session session = HibernateUtil.getSession();
		Todo todo = (Todo) session.get(Todo.class, id);
		session.close();
		return todo;
	}

	public List<Todo> getAllTodo() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
