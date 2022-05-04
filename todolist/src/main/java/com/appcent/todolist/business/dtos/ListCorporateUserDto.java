package com.appcent.todolist.business.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCorporateUserDto {

	private int corporateUserId;
	
	private String companyName;
	
	private String taxNumber;
	
	private String email;
	
	private String password;
	
	private List<ListTaskDto> tasks;
	
}
