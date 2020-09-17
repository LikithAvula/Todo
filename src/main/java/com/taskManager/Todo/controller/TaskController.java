package com.taskManager.Todo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskManager.Todo.entitiy.Task;
import com.taskManager.Todo.service.TaskService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping()
public class TaskController {

	@Autowired
	TaskService taskService;
	
	
	@GetMapping("/allTasks/{userName}")
	public List<Task> getAllTasks(@PathVariable String userName) {
		return addData();		
	}	

	@DeleteMapping("/deleteTask/{userName}/{id}")
	//@RequestMapping(value="/deleteTask/{id}", method= {RequestMethod.DELETE,RequestMethod.GET})
	public List<Task> deleteTask(@PathVariable String userName, @PathVariable int id) {
		taskService.deleteTask(id,userName);
		return addData();
	}
	
	@PutMapping("/editTask/{userName}/{id}")
	public void editTask(@RequestBody Task task, @PathVariable String userName, @PathVariable int id) {
		taskService.updateTask(task);
	}
	
	@PostMapping("/addTask/{userName}")
	public List<Task> addTask(@RequestBody Task task, @PathVariable String userName) {
		taskService.addTask(task);
		return addData();
	}
	
	@GetMapping("/task/{userName}/{id}")
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
