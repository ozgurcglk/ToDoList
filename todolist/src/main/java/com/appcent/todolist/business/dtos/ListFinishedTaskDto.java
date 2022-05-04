package com.appcent.todolist.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListFinishedTaskDto {
	
	private int finishedTaskId;
	
	private int taskId;
	
}
