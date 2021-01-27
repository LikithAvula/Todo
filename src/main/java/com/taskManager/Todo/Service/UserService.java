package com.taskManager.Todo.Service;

import com.taskManager.Todo.entitiy.User;

public interface UserService {
	public User getUserDetails(String userName);
	public void createAccount(User user) throws Exception;
	public void deleteAccount(User user);

}
