package com.taskManager.Todo.Dao;

import java.util.List;
import com.taskManager.Todo.entitiy.Task;

public interface TodoDao {

	public List<Task> getAllTasks(String userName);
	public List<Task> getAllTasksForAdmin(String userName);
	public void deleteTask(int id, String userName);
	public void addTask(Task task);
	public void editTask(Task task);
}
