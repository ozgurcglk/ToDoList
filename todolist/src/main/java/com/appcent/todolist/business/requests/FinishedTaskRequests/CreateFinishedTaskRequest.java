package com.appcent.todolist.business.requests.FinishedTaskRequests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFinishedTaskRequest {
	
	@NotNull
	@Min(1)
	private int taskId;
	
}
