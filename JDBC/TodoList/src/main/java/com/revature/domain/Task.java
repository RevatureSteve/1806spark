package com.revature.domain;

/**
 * 	Task class in domain
 * @author lolitsrhys
 *
 */

public class Task {

	
	private int taskId;
	private int userId;
	private String taskName;
	private int taskStatus;
	private String taskStatusLevel;
	
	public Task() {
		// TODO Auto-generated constructor stub
	}

	public Task(int taskId, int userId, String taskName, int taskStatus, String taskStatusLevel) {
		super();
		this.taskId = taskId;
		this.userId = userId;
		this.taskName = taskName;
		this.taskStatus = taskStatus;
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
		return taskStatus;
	}

	public void setTaskStatus(int taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getTaskStatusLevel() {
		return taskStatusLevel;
	}

	public void setTaskStatusLevel(String taskStatusLevel) {
		this.taskStatusLevel = taskStatusLevel;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", userId=" + userId + ", taskName=" + taskName + ", taskStatus=" + taskStatus
				+ ", taskStatusLevel=" + taskStatusLevel + "]";
	}
	
	
}
