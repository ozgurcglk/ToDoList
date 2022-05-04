package com.appcent.todolist.business.abstracts;

import java.util.List;

import com.appcent.todolist.business.dtos.ListIndividualUserDto;
import com.appcent.todolist.business.requests.IndividualUserRequests.CreateIndividualUserRequest;
import com.appcent.todolist.business.requests.IndividualUserRequests.DeleteIndividualUserRequest;
import com.appcent.todolist.business.requests.IndividualUserRequests.UpdateIndividualUserRequest;
import com.appcent.todolist.core.concretes.BusinessException;
import com.appcent.todolist.core.results.DataResult;
import com.appcent.todolist.core.results.Result;

public interface IndividualUserService {
	
	Result add(CreateIndividualUserRequest createIndividualUserRequest) throws BusinessException;
	
	DataResult<List<ListIndividualUserDto>> getAll();
	DataResult<ListIndividualUserDto> getById(int individualUserId) throws BusinessException;
	
	Result delete(DeleteIndividualUserRequest deleteIndividualUserRequest) throws BusinessException;
	Result update(UpdateIndividualUserRequest updateIndividualUserRequest) throws BusinessException;
	
}
