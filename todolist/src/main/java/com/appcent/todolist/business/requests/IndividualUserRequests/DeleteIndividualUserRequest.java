package com.appcent.todolist.business.requests.IndividualUserRequests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteIndividualUserRequest {

	@NotNull
	@Min(1)
	private int individualUserId;
	
}
