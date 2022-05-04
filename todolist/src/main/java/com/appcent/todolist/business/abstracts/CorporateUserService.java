package com.appcent.todolist.business.abstracts;

import java.util.List;

import com.appcent.todolist.business.dtos.ListCorporateUserDto;
import com.appcent.todolist.business.requests.CorporateUserRequests.CreateCorporateUserRequest;
import com.appcent.todolist.business.requests.CorporateUserRequests.DeleteCorporateUserRequest;
import com.appcent.todolist.business.requests.CorporateUserRequests.UpdateCorporateUserRequest;
import com.appcent.todolist.core.concretes.BusinessException;
import com.appcent.todolist.core.results.DataResult;
import com.appcent.todolist.core.results.Result;

public interface CorporateUserService {

	Result add(CreateCorporateUserRequest createCorporateUserRequest) throws BusinessException;
	
	DataResult<List<ListCorporateUserDto>> getAll();
	DataResult<ListCorporateUserDto> getById(int corporateUserId) throws BusinessException;
	
	Result delete(DeleteCorporateUserRequest deleteCorporateUserRequest) throws BusinessException;
	Result update(UpdateCorporateUserRequest updateCorporateUserRequest) throws BusinessException;
	
}
