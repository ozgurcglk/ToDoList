package com.appcent.todolist.business.requests.TaskRequests;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.type.YesNoType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskRequest {
	
	@NotNull
	@Min(1)
	private int taskId;
	
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
	
	@Value(value = "N")
	private YesNoType isTheTaskFinished;
	
	@NotNull
	private int category_id;
	
	@NotNull
	private int user_id;
	
}
