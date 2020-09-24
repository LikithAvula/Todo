package com.taskManager.Todo.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.taskManager.Todo.entitiy.Task;

@Repository("todoDaoImpl")
public class TodoDaoImpl extends JdbcDaoSupport implements TodoDao{

	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	void initialize() {
		setDataSource(dataSource);
	}
	
	
	@Override
	public List<Task> getAllTasks() {
		List<Map<String,Object>> map = getJdbcTemplate().queryForList("select * from todo");
		
		return Mapper(map);
	}
	
	
	@Override
	public void deleteTask(int id, String userName) {
		getJdbcTemplate().update("delete from todo where id = ?", new Integer(id));
	}
	
	
	List<Task> Mapper(List<Map<String,Object>> result){
		List<Task> tasks = new ArrayList<Task>();
		
		result.forEach( e -> {
			Task task = new Task();
			task.setId(e.get("id").hashCode());
			task.setTaskName(e.get("discription").toString());
			task.setStatus((Boolean)e.get("status"));
			task.setTargetDate(((Date)e.get("targetDate")));
			tasks.add(task);
		});
		tasks.sort(Comparator.comparing(Task::getId));	
		return tasks;
	}


	@Override
	public void addTask(Task task) {
		getJdbcTemplate().update("insert into todo values(?,?,?,?,?)", new Integer(task.getId()), task.getTaskName(),task.isStatus(),
				task.getTargetDate(),task.getUserName());
	}


	@Override
	public void editTask(Task task) {
		getJdbcTemplate().update("update todo set discription =? , targetDate=?, status=? where id =? ", task.getTaskName(),task.getTargetDate(),task.isStatus(),task.getId());
	}



}
