package com.taskManager.Todo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskManager.Todo.Service.TaskService;
import com.taskManager.Todo.entitiy.Task;


@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping()
public class TaskController {

	private static final Void Void = null;
	@Autowired
	TaskService taskService;
	
	BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
	
	@GetMapping("todo/all/{userName}")
	public List<Task> getAllTasks(@PathVariable String userName) {
		return addData();		
	}	

	@DeleteMapping("todo/delete/{userName}/{id}")
	//@RequestMapping(value="/deleteTask/{id}", method= {RequestMethod.DELETE,RequestMethod.GET})
	public List<Task> deleteTask(@PathVariable String userName, @PathVariable int id) {
		taskService.deleteTask(id,userName);
		return addData();
	}
	
	
	// as per rest api standards put mapping should return OK status
	@PutMapping("todo/edit/{userName}/{id}")
	public ResponseEntity<Void> editTask(@RequestBody Task task, @PathVariable String userName, @PathVariable int id) {
		taskService.updateTask(task);
		return new ResponseEntity<Void>(Void,HttpStatus.OK);
	}
	
	@PostMapping("todo/add/{userName}")
	public List<Task> addTask(@RequestBody Task task, @PathVariable String userName) {
		taskService.addTask(task);
		return addData();
	}
	
	@GetMapping("todo/{userName}/{id}")
	public Task taskById(@PathVariable int id, @PathVariable String userName) throws Exception {
		List<Task> task = new ArrayList<Task>();
		addData().forEach(e -> {
			if(e.getId() == id) {
				task.add(e);
			}
		});
		
		if(task.size()>0) {
			return task.get(0);
		}
		else {
			throw new Exception("Record Not Found");
		}
	}
	
	public List<Task> addData(){
		return taskService.getAllTasks();
	}
	
}
