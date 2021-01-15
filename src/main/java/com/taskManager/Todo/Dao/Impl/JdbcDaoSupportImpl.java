package com.taskManager.Todo.Dao.Impl;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcDaoSupportImpl extends JdbcDaoSupport {

	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	void initialize() {
		setDataSource(dataSource);
	}
	
}
