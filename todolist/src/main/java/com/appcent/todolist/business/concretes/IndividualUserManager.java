package com.appcent.todolist.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcent.todolist.business.abstracts.IndividualUserService;
import com.appcent.todolist.business.dtos.ListIndividualUserDto;
import com.appcent.todolist.business.requests.IndividualUserRequests.CreateIndividualUserRequest;
import com.appcent.todolist.business.requests.IndividualUserRequests.DeleteIndividualUserRequest;
import com.appcent.todolist.business.requests.IndividualUserRequests.UpdateIndividualUserRequest;
import com.appcent.todolist.core.concretes.BusinessException;
import com.appcent.todolist.core.constants.Messages;
import com.appcent.todolist.core.results.DataResult;
import com.appcent.todolist.core.results.Result;
import com.appcent.todolist.core.results.SuccessDataResult;
import com.appcent.todolist.core.results.SuccessResult;
import com.appcent.todolist.core.utilities.mapping.ModelMapperService;
import com.appcent.todolist.dataAccess.IndividualUserDao;
import com.appcent.todolist.entities.IndividualUser;

@Service
public class IndividualUserManager implements IndividualUserService{
	
	private IndividualUserDao individualUserDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public IndividualUserManager(IndividualUserDao individualUserDao, ModelMapperService modelMapperService) {
		this.individualUserDao = individualUserDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateIndividualUserRequest createIndividualUserRequest) throws BusinessException {
		
		checkIfEmailExists(createIndividualUserRequest.getEmail());
		IndividualUser individualUser = this.modelMapperService.forRequest()
				.map(createIndividualUserRequest, IndividualUser.class);
		this.individualUserDao.save(individualUser);
		
		return new SuccessResult(Messages.ADDED);
		
	}

	@Override
	public DataResult<List<ListIndividualUserDto>> getAll() {
		
		var result = this.individualUserDao.findAll();
		List<ListIndividualUserDto> response = result.stream()
				.map(individualUser -> this.modelMapperService.forDto()
						.map(individualUser, ListIndividualUserDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListIndividualUserDto>>(response);
	
	}

	@Override
	public DataResult<ListIndividualUserDto> getById(int individualUserId) throws BusinessException {
		
		IndividualUser result = checkIfIndividualUserIdExists(individualUserId);
		ListIndividualUserDto response = this.modelMapperService.forDto()
				.map(result, ListIndividualUserDto.class);
		
		return new SuccessDataResult<ListIndividualUserDto>(response);
	}

	@Override
	public Result delete(DeleteIndividualUserRequest deleteIndividualUserRequest) throws BusinessException {
		
		IndividualUser individualUser = checkIfIndividualUserIdExists(deleteIndividualUserRequest.getIndividualUserId());
		this.individualUserDao.delete(individualUser);
		
		return new SuccessResult(Messages.DELETED);
		
	}

	@Override
	public Result update(UpdateIndividualUserRequest updateIndividualUserRequest) throws BusinessException {
		
		checkIfIndividualUserIdExists(updateIndividualUserRequest.getIndividualUserId());
		
		IndividualUser individualUser = this.modelMapperService.forRequest()
				.map(updateIndividualUserRequest, IndividualUser.class);
		this.individualUserDao.save(individualUser);
		
		return new SuccessResult(Messages.UPDATED);
		
	}
	
	private IndividualUser checkIfIndividualUserIdExists(int individualUserId) throws BusinessException{
		
		IndividualUser result = this.individualUserDao.getByIndividualUserId(individualUserId);
		if(result == null) {
			throw new BusinessException(Messages.NOTFOUND);
		}
		return result;
		
	}
	
	private boolean checkIfEmailExists(String email) throws BusinessException{
		
		IndividualUser individualUser = this.individualUserDao.findByEmail(email);
		if(individualUser != null) {
			throw new BusinessException(Messages.EXISTS);
		}
		return true;
		
	}
	
}
