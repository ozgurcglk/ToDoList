package com.appcent.todolist.business.requests.IndividualUserRequests;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateIndividualUserRequest {
	
	@NotNull
	@Min(1)
	private int individualUserId;

	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Size(min = 5)
	private String password;
	
	@NotNull
	@Size(min = 1, max = 20)
	private String firstName;
	
	@NotNull
	@Size(min = 1, max = 20)
	private String lastName;
	
	@NotNull
	private String nationalityId;
	
}
