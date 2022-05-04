package com.appcent.todolist.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcent.todolist.business.abstracts.OnGoingTaskService;
import com.appcent.todolist.business.abstracts.TaskService;
import com.appcent.todolist.business.dtos.ListOnGoingTaskDto;
import com.appcent.todolist.business.requests.OnGoingTaskRequests.CreateOnGoingTaskRequest;
import com.appcent.todolist.business.requests.OnGoingTaskRequests.DeleteOnGoingTaskRequest;
import com.appcent.todolist.business.requests.OnGoingTaskRequests.UpdateOnGoingTaskRequest;
import com.appcent.todolist.core.concretes.BusinessException;
import com.appcent.todolist.core.constants.Messages;
import com.appcent.todolist.core.results.DataResult;
import com.appcent.todolist.core.results.Result;
import com.appcent.todolist.core.results.SuccessDataResult;
import com.appcent.todolist.core.results.SuccessResult;
import com.appcent.todolist.core.utilities.mapping.ModelMapperService;
import com.appcent.todolist.dataAccess.OnGoingTaskDao;
import com.appcent.todolist.entities.OnGoingTask;

@Service
public class OnGoingTaskManager implements OnGoingTaskService{
	
	private OnGoingTaskDao onGoingTaskDao;
	private ModelMapperService modelMapperService;
	private TaskService taskService;
	
	@Autowired
	public OnGoingTaskManager(OnGoingTaskDao onGoingTaskDao, ModelMapperService modelMapperService,
			TaskService taskService) {
		this.onGoingTaskDao = onGoingTaskDao;
		this.modelMapperService = modelMapperService;
		this.taskService = taskService;
	}
	
	@Override
	public Result add(CreateOnGoingTaskRequest createOnGoingTaskRequest) throws BusinessException {
		
		checkIfTaskIdExists(createOnGoingTaskRequest.getTaskId());
		
		OnGoingTask onGoingTask = this.modelMapperService.forRequest()
				.map(createOnGoingTaskRequest, OnGoingTask.class);
		this.onGoingTaskDao.save(onGoingTask);
		
		return new SuccessResult(Messages.ADDED);
		
	}
	@Override
	public DataResult<List<ListOnGoingTaskDto>> getAll() {
		
		var result = this.onGoingTaskDao.findAll();
		List<ListOnGoingTaskDto> response = result.stream()
				.map(onGoingTask -> this.modelMapperService.forDto()
				.map(onGoingTask, ListOnGoingTaskDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListOnGoingTaskDto>>(response);
		
	}
	@Override
	public Result delete(DeleteOnGoingTaskRequest deleteOnGoingTaskRequest) throws BusinessException {
		
		OnGoingTask onGoingTask = checkIfOnGoingTaskIdExists(deleteOnGoingTaskRequest.getOnGoingTaskId());
		this.onGoingTaskDao.delete(onGoingTask);
		return new SuccessResult(Messages.DELETED);
		
	}
	@Override
	public Result update(UpdateOnGoingTaskRequest updateOnGoingTaskRequest) throws BusinessException {
		
		checkIfOnGoingTaskIdExists(updateOnGoingTaskRequest.getOnGoingTaskId());
		
		OnGoingTask onGoingTask = this.modelMapperService.forRequest()
				.map(updateOnGoingTaskRequest, OnGoingTask.class);
		this.onGoingTaskDao.save(onGoingTask);
		
		return new SuccessResult(Messages.UPDATED);
		
	}
	
	private OnGoingTask checkIfOnGoingTaskIdExists(int onGoingTaskId) throws BusinessException{
		
		OnGoingTask result = this.onGoingTaskDao.getByOnGoingTaskId(onGoingTaskId);
		if(result == null) {
			throw new BusinessException(Messages.NOTFOUND);
		}
		return result;
		
	}
	
	private boolean checkIfTaskIdExists(int taskId) throws BusinessException{
		
		if(this.taskService.getById(taskId) == null) {
			throw new BusinessException(Messages.NOTFOUND);
		}
		return true;
		
	}
	
}
