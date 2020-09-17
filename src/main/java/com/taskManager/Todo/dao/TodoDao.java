package com.taskManager.Todo.dao;

import java.util.List;
import com.taskManager.Todo.entitiy.Task;

public interface TodoDao {

	public List<Task> getAllTasks();
	public void deleteTask(int id, String userName);
	public void addTask(Task task);
	public void editTask(Task task);
}
