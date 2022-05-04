package com.appcent.todolist.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcent.todolist.business.abstracts.CategoryService;
import com.appcent.todolist.business.dtos.ListCategoryDto;
import com.appcent.todolist.business.requests.CategoryRequests.CreateCategoryRequest;
import com.appcent.todolist.business.requests.CategoryRequests.DeleteCategoryRequest;
import com.appcent.todolist.business.requests.CategoryRequests.UpdateCategoryRequest;
import com.appcent.todolist.core.concretes.BusinessException;
import com.appcent.todolist.core.constants.Messages;
import com.appcent.todolist.core.results.DataResult;
import com.appcent.todolist.core.results.Result;
import com.appcent.todolist.core.results.SuccessDataResult;
import com.appcent.todolist.core.results.SuccessResult;
import com.appcent.todolist.core.utilities.mapping.ModelMapperService;
import com.appcent.todolist.dataAccess.CategoryDao;
import com.appcent.todolist.entities.Category;

@Service
public class CategoryManager implements CategoryService{
	
	private CategoryDao categoryDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public CategoryManager(CategoryDao categoryDao, ModelMapperService modelMapperService) {
		this.categoryDao = categoryDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateCategoryRequest createCategoryRequest) throws BusinessException {
		
		checkIfCategoryNameExists(createCategoryRequest.getCategoryName());
		
		Category category = this.modelMapperService.forRequest()
				.map(createCategoryRequest, Category.class);
		this.categoryDao.save(category);
		
		return new SuccessResult(Messages.ADDED);
		
	}

	@Override
	public DataResult<List<ListCategoryDto>> getAll() {
		
		var result = this.categoryDao.findAll();
		List<ListCategoryDto> response = result.stream()
				.map(category -> this.modelMapperService.forDto()
						.map(category, ListCategoryDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCategoryDto>>(response);
	
	}

	@Override
	public DataResult<ListCategoryDto> getById(int categoryId) throws BusinessException {
		
		Category category = checkIfCategoryIdExists(categoryId);
		ListCategoryDto response = this.modelMapperService.forDto()
				.map(category, ListCategoryDto.class);
		return new SuccessDataResult<ListCategoryDto>(response);
		
	}

	@Override
	public Result delete(DeleteCategoryRequest deleteCategoryRequest) throws BusinessException {
		
		var result = checkIfCategoryIdExists(deleteCategoryRequest.getCategoryId());
		this.categoryDao.delete(result);
		
		return new SuccessResult(Messages.DELETED);
		
	}

	@Override
	public Result update(UpdateCategoryRequest updateCategoryRequest) throws BusinessException {
		
		var result = checkIfCategoryIdExists(updateCategoryRequest.getCategoryId());
		result = this.modelMapperService.forRequest()
				.map(updateCategoryRequest, Category.class);
		this.categoryDao.save(result);
		
		return new SuccessResult(Messages.UPDATED);
		
	}
	
	private Category checkIfCategoryIdExists(int categoryId) throws BusinessException{
		
		Category result = this.categoryDao.getByCategoryId(categoryId);
		if(result == null) {
			throw new BusinessException(Messages.NOTFOUND);
		}
		return result;
		
	}
	
	private boolean checkIfCategoryNameExists(String categoryName) throws BusinessException{
		
		var result = this.categoryDao.getByCategoryName(WordUtils.capitalize(categoryName));
		if(result == null) {
			return true;
		}
		throw new BusinessException(Messages.EXISTS);
		
	}
	
	
}
