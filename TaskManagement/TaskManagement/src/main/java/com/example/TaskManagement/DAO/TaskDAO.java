package com.example.TaskManagement.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.TaskManagement.DTO.Task;
import com.example.TaskManagement.Repository.TaskRepository;

@Repository//It is a class level annotation which will inform to perform operations on database
public class TaskDAO //all the database operations should be performed in DAO class
{
	@Autowired//Informing spring to inject object to repository variable
	TaskRepository repository;
	//to save objects to DB
	public Task saveTask(Task task)
	{
		return repository.save(task);//save is a inbuilt method in JPArepository to save the object, which object is to be saved will be given as input
	}
	//to find objects in DB based on id
	public Task findTask(int id)
	{
		Optional<Task> opt = repository.findById(id);//Optional is a class in java 8 version it is used to dealing with null pointer exception.
							//It is used for storing not null values(empty)
		if(opt.isPresent())
		{
			Task t=opt.get();
			return t;
		}
		
		return null;
		
	}
	//to delete objects in DB based on ID
	public String deleteTask(int id)
	{
		Task t=findTask(id);
		if(t != null)
		{
			repository.deleteById(id);
			return "Task deleted successfully.....";
		}
		return "Task ID not found....";
	}
	//to retrieve all objects from DB
	public List<Task> findAllTask()
	{
		return repository.findAll();//It will retrieve all the objects in the database which is present in list
	}
	//to update object based on id
	public String updateStatus(int id,String newStatus)
	{
		Task t=findTask(id);
		if(t != null)
		{
			t.setStatus(newStatus);
			repository.save(t);
			return "Uptated successfully..Status of ur task is : "+ newStatus;
		}
		return "Task ID not found....";
	}
}