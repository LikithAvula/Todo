package com.taskManager.Todo.Dao;

import com.taskManager.Todo.entitiy.User;

public interface UserDao {
	
	public User getUserDetails(String userName);
	public void createAccount(User user);
	public void deleteAccount(User user);

}
