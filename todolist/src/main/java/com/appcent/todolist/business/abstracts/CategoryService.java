package com.appcent.todolist.business.abstracts;

import java.util.List;

import com.appcent.todolist.business.dtos.ListCategoryDto;
import com.appcent.todolist.business.requests.CategoryRequests.CreateCategoryRequest;
import com.appcent.todolist.business.requests.CategoryRequests.DeleteCategoryRequest;
import com.appcent.todolist.business.requests.CategoryRequests.UpdateCategoryRequest;
import com.appcent.todolist.core.concretes.BusinessException;
import com.appcent.todolist.core.results.DataResult;
import com.appcent.todolist.core.results.Result;

public interface CategoryService {
	
	Result add(CreateCategoryRequest createCategoryRequest) throws BusinessException;
	
	DataResult<List<ListCategoryDto>> getAll();
	DataResult<ListCategoryDto> getById(int categoryId) throws BusinessException;
	
	Result delete(DeleteCategoryRequest deleteCategoryRequest) throws BusinessException;
	Result update(UpdateCategoryRequest updateCategoryRequest) throws BusinessException;
	
}
