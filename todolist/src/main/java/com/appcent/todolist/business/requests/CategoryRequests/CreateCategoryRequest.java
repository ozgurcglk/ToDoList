package com.appcent.todolist.business.requests.CategoryRequests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryRequest {

	@NotNull
	@Size(min = 1, max = 20)
	private String categoryName;
	
}
