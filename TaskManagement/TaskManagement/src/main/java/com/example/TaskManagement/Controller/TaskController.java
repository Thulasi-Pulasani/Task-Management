package com.example.TaskManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskManagement.DAO.TaskDAO;
import com.example.TaskManagement.DTO.Task;

@RestController//request will be received from the client and if we want to use RESTfull web services or REST API's
				//RESTfull services means an API which accepts HTTPRequest and gives HTTPResponse
public class TaskController 
{
	@Autowired
	TaskDAO dao;
	
	@PostMapping("/add")//it will map only the incoming post request.It will accept endpoints(url).
	public Task addTask(@RequestBody Task task)//It is used to inform input is of object type to the server.
	{
		return dao.saveTask(task);
	}
	@GetMapping("/add")
	public Task searchTask(@RequestParam int id)//it is used to refer the input is parameter of the object
	{
		return dao.findTask(id);
	}
	@DeleteMapping("/delete")
	public String removeTask(@RequestParam int id)
	{
		 return dao.deleteTask(id);
	}
	@GetMapping("/find")
	public List<Task> findAll()
	{
		return dao.findAllTask();
	}
	@PutMapping("/add")//@PutMapping will help to update the existing object
	public String updateTask(@RequestParam int id,@RequestParam String status)
	{
		return dao.updateStatus(id, status);
	}
}
