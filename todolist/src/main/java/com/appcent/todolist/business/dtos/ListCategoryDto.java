package com.appcent.todolist.business.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCategoryDto {

	private int categoryId;
	
	private String categoryName;
	
	private List<ListTaskDto> tasks;
	
}
