package com.appcent.todolist.business.requests.OnGoingTaskRequests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOnGoingTaskRequest {

	@NotNull
	@Min(1)
	private int onGoingTaskId;
	
	@NotNull
	@Min(1)
	private int taskId;
	
}
