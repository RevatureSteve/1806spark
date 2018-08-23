package com.revature;

import com.revature.dao.TodoDao;
import com.revature.dao.TodoDaoImpl;
import com.revature.pojo.Task;

public class MainClass {
	
	/*
	 * testing the get task by id 
	 * testing the create new task
	 */
	public static void main (String [] args) {
		TodoDao dao = new TodoDaoImpl();

//		Task tk = dao.getTaskById(42);
		
//		Task tk = new Task(42, 1," a book", 1);
//		dao.createTask(tk);

//		System.out.println(tk);
	}

}
