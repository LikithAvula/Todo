package com.taskManager.Todo.service;

import java.util.List;

import com.taskManager.Todo.entitiy.Task;


public interface TaskService {
	public List<Task> getAllTasks();
	
	public Task getTask(int id);
	
	public boolean deleteTask(int id, String userName);
	
	public void updateTask(Task task);
	
	public void addTask(Task task);
}
