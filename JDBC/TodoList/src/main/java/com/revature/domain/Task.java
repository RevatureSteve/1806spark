package com.revature.domain;

public class Task {

	private int taskId;
	private int userId;
	private String taskName;
	private int taskStatusID;
	private String taskStatusLevel;
	
	public Task() {}

	public Task(int taskId, int userId, String taskName, int taskStatusID, String taskStatusLevel) {
		super();
		this.taskId = taskId;
		this.userId = userId;
		this.taskName = taskName;
		this.taskStatusID = taskStatusID;
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

	public int getTaskStatusID() {
		return taskStatusID;
	}

	public void setTaskStatusID(int taskStatusID) {
		this.taskStatusID = taskStatusID;
	}

	public String getTaskStatusLevel() {
		return taskStatusLevel;
	}

	public void setTaskStatusLevel(String taskStatusLevel) {
		this.taskStatusLevel = taskStatusLevel;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", userId=" + userId + ", taskName=" + taskName + ", taskStatusID="
				+ taskStatusID + ", taskStatusLevel=" + taskStatusLevel + "]";
	}
	
	
	
}
