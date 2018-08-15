/**
 * 
 */
package com.revature.domain;

import java.util.List;

/**
 * @author sethc
 *
 */
public class Task {

	private int taskId;
	private int userId;
	private String taskName;
	private int TaskStatus;
	private String taskStatusLevel;
	
	// additionally property i probably will need here(not a field/ attritube in data)
	// i know user will have multiple task
	
	private List<Task> userTasks;
	
	public Task() {
		//no args
	}
	
	
	
	/**
	 * @param taskId
	 * @param userId
	 * @param taskName
	 * @param taskStatus
	 * @param taskStatusLevel
	 * @param userTasks
	 */
	//eagar loading from database - get table's information like user's tasks 
	
	public Task(int taskId, int userId, String taskName, int taskStatus, String taskStatusLevel, List<Task> userTasks) {
		super();
		this.taskId = taskId;
		this.userId = userId;
		this.taskName = taskName;
		TaskStatus = taskStatus;
		this.taskStatusLevel = taskStatusLevel;
		this.userTasks = userTasks;
	}


	// lazy loading from the database- only get this table's information not foreign key
	public Task(int taskId, int userId, String taskName, int taskStatus, String taskStatusLevel) {
		super();
		this.taskId = taskId;
		this.userId = userId;
		this.taskName = taskName;
		TaskStatus = taskStatus;
		this.taskStatusLevel = taskStatusLevel;
	}



	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public int getTaskStatus() {
		return TaskStatus;
	}
	public void setTaskStatus(int taskStatus) {
		TaskStatus = taskStatus;
	}
	public String getTaskStatusLevel() {
		return taskStatusLevel;
	}
	public void setTaskStatusLevel(String taskStatusLevel) {
		this.taskStatusLevel = taskStatusLevel;
	}



	/**
	 * @return the userTasks
	 */
	public List<Task> getUserTasks() {
		return userTasks;
	}



	/**
	 * @param userTasks the userTasks to set
	 */
	public void setUserTasks(List<Task> userTasks) {
		this.userTasks = userTasks;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", userId=" + userId + ", taskName=" + taskName + ", TaskStatus=" + TaskStatus
				+ ", taskStatusLevel=" + taskStatusLevel + ", userTasks=" + userTasks + "]";
	} 
	
	
	
}
