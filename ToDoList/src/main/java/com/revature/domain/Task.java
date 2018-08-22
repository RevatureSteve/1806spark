package com.revature.domain;

public class Task {

	private int taskiD;
	private int userId;
	private String taskName;
	private int taskStatusId;
	private String taskStatusLevel;
	
	
	public Task(int taskiD, int userId, String taskName, int taskStatus, String taskStatusLevel) {
		super();
		this.taskiD = taskiD;
		this.userId = userId;
		this.taskName = taskName;
		this.taskStatusId = taskStatus;
		this.taskStatusLevel = taskStatusLevel;
	}


	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getTaskiD() {
		return taskiD;
	}


	public void setTaskiD(int taskiD) {
		this.taskiD = taskiD;
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


	public int getTaskStatusId() {
		return taskStatusId;
	}


	public void setTaskStatus(int taskStatus) {
		this.taskStatusId = taskStatus;
	}


	public String getTaskStatusLevel() {
		return taskStatusLevel;
	}


	public void setTaskStatusLevel(String taskStatusLevel) {
		this.taskStatusLevel = taskStatusLevel;
	}


	@Override
	public String toString() {
		return "Task [taskiD=" + taskiD + ", userId=" + userId + ", taskName=" + taskName + ", taskStatus=" + taskStatusId
				+ ", taskStatusLevel=" + taskStatusLevel + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
