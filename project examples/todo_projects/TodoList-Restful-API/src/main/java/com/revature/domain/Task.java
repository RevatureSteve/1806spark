package com.revature.domain;

/**
<<<<<<< HEAD
 * 	Task class in domain also can be pojo/model/beans (other names for the folder)
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
=======
 * 	Task class in domain
 * @author Steve Work PC
 *
 */
public class Task {

	private int taskId;
	private int userId;
	private String taskName;
	private int taskStatusId;
	private String taskStatusLevel;
	
	public Task() {	}

	public Task(int taskId, int userId, String taskName, int taskStatusId, String taskStatusLevel) {
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
		super();
		this.taskId = taskId;
		this.userId = userId;
		this.taskName = taskName;
<<<<<<< HEAD
		this.taskStatus = taskStatus;
		this.taskStatusLevel = taskStatusLevel;
	}

=======
		this.taskStatusId = taskStatusId;
		this.taskStatusLevel = taskStatusLevel;
	}


>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
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

<<<<<<< HEAD
	public int getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(int taskStatus) {
		this.taskStatus = taskStatus;
=======
	public int getTaskStatusId() {
		return taskStatusId;
	}

	public void setTaskStatusId(int taskStatusId) {
		this.taskStatusId = taskStatusId;
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
	}

	public String getTaskStatusLevel() {
		return taskStatusLevel;
	}

	public void setTaskStatusLevel(String taskStatusLevel) {
		this.taskStatusLevel = taskStatusLevel;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Task [taskId=" + taskId + ", userId=" + userId + ", taskName=" + taskName + ", taskStatus=" + taskStatus
				+ ", taskStatusLevel=" + taskStatusLevel + "]";
	}
	
	
=======
		return "Task [taskId=" + taskId + ", userId=" + userId + ", taskName=" + taskName + ", taskStatusId="
				+ taskStatusId + ", taskStatusLevel=" + taskStatusLevel + "]";
	}
	
	
	
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
}
