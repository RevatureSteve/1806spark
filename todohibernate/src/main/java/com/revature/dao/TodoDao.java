package com.revature.dao;

import java.util.List;

import com.revature.domain.Todo;

public interface TodoDao {
	
	//Create
	
	public void createTodo(Todo todo);
	
	//Read
	
	public Todo getTodoById(int id);
	public List<Todo> getAllTodo();
}
