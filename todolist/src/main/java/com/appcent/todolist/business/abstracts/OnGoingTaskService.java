package com.appcent.todolist.business.abstracts;

import java.util.List;

import com.appcent.todolist.business.dtos.ListOnGoingTaskDto;
import com.appcent.todolist.business.requests.OnGoingTaskRequests.CreateOnGoingTaskRequest;
import com.appcent.todolist.business.requests.OnGoingTaskRequests.DeleteOnGoingTaskRequest;
import com.appcent.todolist.business.requests.OnGoingTaskRequests.UpdateOnGoingTaskRequest;
import com.appcent.todolist.core.concretes.BusinessException;
import com.appcent.todolist.core.results.DataResult;
import com.appcent.todolist.core.results.Result;

public interface OnGoingTaskService {
	
	Result add(CreateOnGoingTaskRequest createOnGoingTaskRequest) throws BusinessException;
	
	DataResult<List<ListOnGoingTaskDto>> getAll();
	
	Result delete(DeleteOnGoingTaskRequest deleteOnGoingTaskRequest) throws BusinessException;
	Result update(UpdateOnGoingTaskRequest updateOnGoingTaskRequest) throws BusinessException;

}
