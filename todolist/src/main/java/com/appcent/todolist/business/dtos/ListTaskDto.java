package com.appcent.todolist.business.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.type.YesNoType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListTaskDto {
	
	private int taskId;
	
	private String taskDescription;
	
	private String taskRelatedWithWho;
	
	private LocalDate taskDueDate;
	
	private LocalTime taskDueTime;
	
	private YesNoType isTheTaskFinished;
	
	private int category_id;
	
	private int user_id;

}
