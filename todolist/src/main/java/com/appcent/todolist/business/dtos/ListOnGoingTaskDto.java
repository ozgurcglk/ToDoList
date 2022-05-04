package com.appcent.todolist.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListOnGoingTaskDto {
	
	private int onGoingTaskId;
	
	private int taskId;
	
}
