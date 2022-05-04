package com.appcent.todolist.business.abstracts;

import java.util.List;

import com.appcent.todolist.business.dtos.ListTaskDto;
import com.appcent.todolist.business.requests.TaskRequests.CreateTaskRequest;
import com.appcent.todolist.business.requests.TaskRequests.DeleteTaskRequest;
import com.appcent.todolist.business.requests.TaskRequests.UpdateTaskRequest;
import com.appcent.todolist.core.concretes.BusinessException;
import com.appcent.todolist.core.results.DataResult;
import com.appcent.todolist.core.results.Result;

public interface TaskService {
	Result add(CreateTaskRequest createTaskRequest) throws BusinessException;
	
	DataResult<List<ListTaskDto>> getAll();
	DataResult<ListTaskDto> getById(int taskId) throws BusinessException;
	
	Result delete(DeleteTaskRequest deleteTaskRequest) throws BusinessException;
	Result update(UpdateTaskRequest updateTaskRequest) throws BusinessException;

}
