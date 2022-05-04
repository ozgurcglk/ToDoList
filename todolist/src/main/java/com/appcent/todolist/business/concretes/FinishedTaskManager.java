package com.appcent.todolist.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcent.todolist.business.abstracts.FinishedTaskService;
import com.appcent.todolist.business.abstracts.TaskService;
import com.appcent.todolist.business.dtos.ListFinishedTaskDto;
import com.appcent.todolist.business.requests.FinishedTaskRequests.CreateFinishedTaskRequest;
import com.appcent.todolist.business.requests.FinishedTaskRequests.DeleteFinishedTaskRequest;
import com.appcent.todolist.business.requests.FinishedTaskRequests.UpdateFinishedTaskRequest;
import com.appcent.todolist.core.concretes.BusinessException;
import com.appcent.todolist.core.constants.Messages;
import com.appcent.todolist.core.results.DataResult;
import com.appcent.todolist.core.results.Result;
import com.appcent.todolist.core.results.SuccessDataResult;
import com.appcent.todolist.core.results.SuccessResult;
import com.appcent.todolist.core.utilities.mapping.ModelMapperService;
import com.appcent.todolist.dataAccess.FinishedTaskDao;
import com.appcent.todolist.entities.FinishedTask;

@Service
public class FinishedTaskManager implements FinishedTaskService{
	
	private FinishedTaskDao finishedTaskDao;
	private ModelMapperService modelMapperService;
	private TaskService taskService;
	
	@Autowired
	public FinishedTaskManager(FinishedTaskDao finishedTaskDao, ModelMapperService modelMapperService,
			TaskService taskService) {

		this.finishedTaskDao = finishedTaskDao;
		this.modelMapperService = modelMapperService;
		this.taskService = taskService;
	}

	@Override
	public Result add(CreateFinishedTaskRequest createFinishedTaskRequest) throws BusinessException {
		
		checkIfTaskIdExists(createFinishedTaskRequest.getTaskId());
		
		FinishedTask finishedTask = this.modelMapperService.forRequest()
				.map(createFinishedTaskRequest, FinishedTask.class);
		this.finishedTaskDao.save(finishedTask);
		
		return new SuccessResult(Messages.ADDED);
		
	}

	@Override
	public DataResult<List<ListFinishedTaskDto>> getAll() {
		
		var result = this.finishedTaskDao.findAll();
		List<ListFinishedTaskDto> response = result.stream()
				.map(finishedTask -> this.modelMapperService.forDto()
				.map(finishedTask, ListFinishedTaskDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListFinishedTaskDto>>(response);
		
	}

	@Override
	public Result delete(DeleteFinishedTaskRequest deleteFinishedTaskRequest) throws BusinessException {
		
		FinishedTask finishedTask = checkIfFinishedTaskIdExists(deleteFinishedTaskRequest.getFinishedTaskId());
		this.finishedTaskDao.delete(finishedTask);
		
		return new SuccessResult(Messages.DELETED);
		
	}

	@Override
	public Result update(UpdateFinishedTaskRequest updateFinishedTaskRequest) throws BusinessException {
		
		checkIfFinishedTaskIdExists(updateFinishedTaskRequest.getFinishedTaskId());
		
		FinishedTask finishedTask = this.modelMapperService.forRequest()
				.map(updateFinishedTaskRequest, FinishedTask.class);
		this.finishedTaskDao.save(finishedTask);
		
		return new SuccessResult(Messages.UPDATED);
		
	}

	private FinishedTask checkIfFinishedTaskIdExists(int finishedTaskId) throws BusinessException{
		
		FinishedTask result = this.finishedTaskDao.getByFinishedTaskId(finishedTaskId);
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
