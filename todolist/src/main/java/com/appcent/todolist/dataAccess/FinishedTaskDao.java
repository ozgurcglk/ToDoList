package com.appcent.todolist.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.todolist.entities.FinishedTask;

@Repository
public interface FinishedTaskDao extends JpaRepository<FinishedTask, Integer>{
	
	FinishedTask getByFinishedTaskId(int finishedTaskId);
	
}
