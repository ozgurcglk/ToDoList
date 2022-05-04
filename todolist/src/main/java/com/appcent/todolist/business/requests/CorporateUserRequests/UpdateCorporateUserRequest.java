package com.appcent.todolist.business.requests.CorporateUserRequests;

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
public class UpdateCorporateUserRequest {
	
	@NotNull
	@Min(1)
	private int corporateUserId;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Size(min = 5)
	private String password;
	
	@NotNull
	private String taxNumber;
	
	@NotNull
	@Size(min = 1, max = 40)
	private String companyName;
	
}
