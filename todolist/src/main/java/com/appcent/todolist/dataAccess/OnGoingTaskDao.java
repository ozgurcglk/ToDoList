package com.appcent.todolist.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.todolist.entities.OnGoingTask;

@Repository
public interface OnGoingTaskDao extends JpaRepository<OnGoingTask, Integer> {
	
	OnGoingTask getByOnGoingTaskId(int onGoingTaskId);
	
}
