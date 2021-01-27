package com.taskManager.Todo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskManager.Todo.Dao.TodoDao;
import com.taskManager.Todo.Service.TaskService;
import com.taskManager.Todo.entitiy.Task;

@Service("taskServiceImpl")
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	TodoDao todoDaoImpl;

	@Override
	public List<Task> getAllTasks(String userName) {
		return todoDaoImpl.getAllTasks(userName);
	}

	@Override
	public Task getTask(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteTask(int id, String userName) {
		todoDaoImpl.deleteTask(id,userName);
		return false;
	}

	@Override
	public void updateTask(Task task) {
		todoDaoImpl.editTask(task);
	}

	@Override
	public void addTask(Task task) {
		todoDaoImpl.addTask(task);
	}

	@Override
	public List<Task> getAllTasksForAdmin(String userName) {		
		return todoDaoImpl.getAllTasksForAdmin(userName);
	}

}
