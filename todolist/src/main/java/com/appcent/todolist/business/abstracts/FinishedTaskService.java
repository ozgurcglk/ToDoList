package com.appcent.todolist.business.abstracts;

import java.util.List;

import com.appcent.todolist.business.dtos.ListFinishedTaskDto;
import com.appcent.todolist.business.requests.FinishedTaskRequests.CreateFinishedTaskRequest;
import com.appcent.todolist.business.requests.FinishedTaskRequests.DeleteFinishedTaskRequest;
import com.appcent.todolist.business.requests.FinishedTaskRequests.UpdateFinishedTaskRequest;
import com.appcent.todolist.core.concretes.BusinessException;
import com.appcent.todolist.core.results.DataResult;
import com.appcent.todolist.core.results.Result;

public interface FinishedTaskService {

	Result add(CreateFinishedTaskRequest createFinishedTaskRequest) throws BusinessException;
	
	DataResult<List<ListFinishedTaskDto>> getAll();
	
	Result delete(DeleteFinishedTaskRequest deleteFinishedTaskRequest) throws BusinessException;
	Result update(UpdateFinishedTaskRequest updateFinishedTaskRequest) throws BusinessException;
	
}
