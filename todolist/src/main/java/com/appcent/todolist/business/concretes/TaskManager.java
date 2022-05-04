package com.appcent.todolist.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcent.todolist.business.abstracts.CategoryService;
import com.appcent.todolist.business.abstracts.CorporateUserService;
import com.appcent.todolist.business.abstracts.IndividualUserService;
import com.appcent.todolist.business.abstracts.TaskService;
import com.appcent.todolist.business.dtos.ListTaskDto;
import com.appcent.todolist.business.requests.TaskRequests.CreateTaskRequest;
import com.appcent.todolist.business.requests.TaskRequests.DeleteTaskRequest;
import com.appcent.todolist.business.requests.TaskRequests.UpdateTaskRequest;
import com.appcent.todolist.core.concretes.BusinessException;
import com.appcent.todolist.core.constants.Messages;
import com.appcent.todolist.core.results.DataResult;
import com.appcent.todolist.core.results.Result;
import com.appcent.todolist.core.results.SuccessDataResult;
import com.appcent.todolist.core.results.SuccessResult;
import com.appcent.todolist.core.utilities.mapping.ModelMapperService;
import com.appcent.todolist.dataAccess.TaskDao;
import com.appcent.todolist.entities.Task;

@Service
public class TaskManager implements TaskService{
	
	private TaskDao taskDao;
	private ModelMapperService modelMapperService;
	private CategoryService categoryService;
	private IndividualUserService individualUserService;
	private CorporateUserService corporateUserService;
	

	@Autowired
	public TaskManager(TaskDao taskDao, ModelMapperService modelMapperService, CategoryService categoryService,
			IndividualUserService individualUserService, CorporateUserService corporateUserService) {
		this.taskDao = taskDao;
		this.modelMapperService = modelMapperService;
		this.categoryService = categoryService;
		this.individualUserService = individualUserService;
		this.corporateUserService = corporateUserService;
	}

	@Override
	public Result add(CreateTaskRequest createTaskRequest) throws BusinessException {
		
		checkIfCategoryExists(createTaskRequest.getCategoryId());
		checkIfUserExists(createTaskRequest.getUserId());
		
		Task task = this.modelMapperService.forRequest()
				.map(createTaskRequest, Task.class);
		this.taskDao.save(task);
		
		return new SuccessResult(Messages.ADDED);
		
	}

	@Override
	public DataResult<List<ListTaskDto>> getAll() {
		
		var result = this.taskDao.findAll();
		List<ListTaskDto> response = result.stream()
				.map(task -> this.modelMapperService.forDto()
						.map(task, ListTaskDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListTaskDto>>(response);
	
	}

	@Override
	public DataResult<ListTaskDto> getById(int taskId) throws BusinessException {
		
		Task result = checkIfTaskIdExists(taskId);
		ListTaskDto response = this.modelMapperService.forDto()
				.map(result, ListTaskDto.class);
		return new SuccessDataResult<ListTaskDto>(response);
		
	}

	@Override
	public Result delete(DeleteTaskRequest deleteTaskRequest) throws BusinessException {
		
		Task task = checkIfTaskIdExists(deleteTaskRequest.getTaskId());
		
		this.taskDao.delete(task);
		return new SuccessResult(Messages.DELETED);
		
	}

	@Override
	public Result update(UpdateTaskRequest updateTaskRequest) throws BusinessException {
		
		checkIfTaskIdExists(updateTaskRequest.getTaskId());
		Task task = this.modelMapperService.forRequest()
				.map(updateTaskRequest, Task.class);
		this.taskDao.save(task);
		
		return new SuccessResult(Messages.UPDATED);
		
	}
	
	private Task checkIfTaskIdExists(int taskId) throws BusinessException{
		
		Task result = this.taskDao.getByTaskId(taskId);
		if(result == null) {
			throw new BusinessException(Messages.NOTFOUND);
		}
		return result;
		
	}
	
	private boolean checkIfCategoryExists(int categoryId) throws BusinessException{
		
		if(this.categoryService.getById(categoryId) == null) {
			throw new BusinessException(Messages.NOTFOUND);
		} 
		return true;
		
	}
	
	private boolean checkIfUserExists(int userId) throws BusinessException{
		
		if(this.corporateUserService.getById(userId) == null || this.individualUserService.getById(userId) == null) {
			throw new BusinessException(Messages.NOTFOUND);
		}
		return true;
		
	}
	
}
