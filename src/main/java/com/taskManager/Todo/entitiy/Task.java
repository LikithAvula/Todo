package com.taskManager.Todo.entitiy;

import java.util.Date;

public class Task {
	private int id;
	private String taskName;
	private boolean status;
	private Date targetDate;
	private String userName;
	
	public Task() {
		
	}

	/*
	 * public Task(int id, String taskName, boolean status, Date targetDate) {
	 * super(); this.id = id; this.taskName = taskName; this.status = status;
	 * this.targetDate = targetDate; }
	 */
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
