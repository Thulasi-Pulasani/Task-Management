package com.example.TaskManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.TaskManagement.DTO.Task;
public interface TaskRepository extends JpaRepository<Task, Integer>
{
//repository provides methods to perform operations on database.
}
