package com.appcent.todolist.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.todolist.entities.Task;

@Repository
public interface TaskDao extends JpaRepository<Task, Integer>{
	
	Task getByTaskId(int taskId);
	
}
