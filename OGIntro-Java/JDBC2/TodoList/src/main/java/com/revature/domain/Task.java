package com.revature.domain;

/**
 * Ysdk vlsdd in domain
 * @author christopherholmes
 *
 */
public class Task {

	private int taskId;
	private int userId;
	private String taskName;
	private int taksStatusId;
	private String tastStatusLevel;
	
	public Task () {}
	
	

	public Task(int taskId, int userId, String taskName, int taksStatusId, String tastStatusLevel) {
		super();
		this.taskId = taskId;
		this.userId = userId;
		this.taskName = taskName;
		this.taksStatusId = taksStatusId;
		this.tastStatusLevel = tastStatusLevel;
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

	public int getTaksStatusId() {
		return taksStatusId;
	}

	public void setTaksStatusId(int taksStatusId) {
		this.taksStatusId = taksStatusId;
	}

	public String getTastStatusLevel() {
		return tastStatusLevel;
	}

	public void setTastStatusLevel(String tastStatusLevel) {
		this.tastStatusLevel = tastStatusLevel;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", userId=" + userId + ", taskName=" + taskName + ", taksStatusId="
				+ taksStatusId + ", tastStatusLevel=" + tastStatusLevel + "]";
	}
	
	
}
