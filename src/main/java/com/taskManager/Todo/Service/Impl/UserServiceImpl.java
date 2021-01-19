package com.taskManager.Todo.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskManager.Todo.Dao.UserDao;
import com.taskManager.Todo.Service.UserService;
import com.taskManager.Todo.entitiy.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserDao userDao;

	@Override
	public User getUserDetails(String userName) {		
		return userDao.getUserDetails(userName);
	}

	@Override
	public void createAccount(User user) throws Exception {
		userDao.createAccount(user);
	}

	@Override
	public void deleteAccount(User user) {
		// TODO Auto-generated method stub
		
	}

}
