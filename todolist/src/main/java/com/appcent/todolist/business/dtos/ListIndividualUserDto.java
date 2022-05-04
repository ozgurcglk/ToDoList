package com.appcent.todolist.business.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListIndividualUserDto {
	
	private int individualUserId;
	
	private String firstName;
	
	private String lastName;
	
	private String nationalityId;
	
	private String email;
	
	private String password;
	
	private List<ListTaskDto> tasks;
	
}
