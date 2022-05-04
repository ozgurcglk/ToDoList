package com.appcent.todolist.business.requests.TaskRequests;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.type.YesNoType;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskRequest {
	
	@NotNull
	@Size(min = 1, max = 50)
	private String taskDescription;
	
	@Nullable
	@Size(min = 1, max = 50)
	private String taskRelatedWithWho;
	
	@Nullable
	private LocalDate taskDueDate;
	
	@Nullable
	private LocalTime taskDueTime;
	
	
	private YesNoType isTheTaskFinished;
	
	@NotNull
	private int categoryId;
	
	@NotNull
	private int userId;
	
}
