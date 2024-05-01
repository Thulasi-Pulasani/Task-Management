package com.example.TaskManagement.DTO;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data //getters and setters will be implicitly added
public class Task 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//to generate automatic id starting from 1.//Identity is most supported strategy for mysql.
	private int id;
	private String title;
	private String description;
	private String status;
	private String priority;
	private String target_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getTarget_date() {
		return target_date;
	}
	public void setTarget_date(String target_date) {
		this.target_date = target_date;
	}
	
}
