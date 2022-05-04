package com.appcent.todolist.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appcent.todolist.business.abstracts.CategoryService;
import com.appcent.todolist.business.dtos.ListCategoryDto;
import com.appcent.todolist.business.requests.CategoryRequests.CreateCategoryRequest;
import com.appcent.todolist.business.requests.CategoryRequests.DeleteCategoryRequest;
import com.appcent.todolist.business.requests.CategoryRequests.UpdateCategoryRequest;
import com.appcent.todolist.core.concretes.BusinessException;
import com.appcent.todolist.core.results.DataResult;
import com.appcent.todolist.core.results.Result;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/categories/")
public class CategoryControllers {
	
	private CategoryService categoryService;
	
	@Autowired
	public CategoryControllers(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateCategoryRequest createCategoryRequest) throws BusinessException{
		return this.categoryService.add(createCategoryRequest);
	}
	
	@GetMapping("/getALL")
	public DataResult<List<ListCategoryDto>> getAll(){
		return this.categoryService.getAll();
	}
	
	@GetMapping("/getByCategoryId")
	public DataResult<ListCategoryDto> getById(@RequestParam @Valid int categoryId) throws BusinessException{
		return this.categoryService.getById(categoryId);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdateCategoryRequest updateCategoryRequest) throws BusinessException{
		return this.categoryService.update(updateCategoryRequest);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteCategoryRequest deleteCategoryRequest) throws BusinessException{
		return this.delete(deleteCategoryRequest);
	}
	
}
