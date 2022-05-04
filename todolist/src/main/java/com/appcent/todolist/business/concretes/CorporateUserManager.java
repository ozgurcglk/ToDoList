package com.appcent.todolist.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcent.todolist.business.abstracts.CorporateUserService;
import com.appcent.todolist.business.dtos.ListCorporateUserDto;
import com.appcent.todolist.business.requests.CorporateUserRequests.CreateCorporateUserRequest;
import com.appcent.todolist.business.requests.CorporateUserRequests.DeleteCorporateUserRequest;
import com.appcent.todolist.business.requests.CorporateUserRequests.UpdateCorporateUserRequest;
import com.appcent.todolist.core.concretes.BusinessException;
import com.appcent.todolist.core.constants.Messages;
import com.appcent.todolist.core.results.DataResult;
import com.appcent.todolist.core.results.Result;
import com.appcent.todolist.core.results.SuccessDataResult;
import com.appcent.todolist.core.results.SuccessResult;
import com.appcent.todolist.core.utilities.mapping.ModelMapperService;
import com.appcent.todolist.dataAccess.CorporateUserDao;
import com.appcent.todolist.entities.CorporateUser;

@Service
public class CorporateUserManager implements CorporateUserService{
	
	private CorporateUserDao corporateUserDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public CorporateUserManager(CorporateUserDao corporateUserDao, ModelMapperService modelMapperService) {
		this.corporateUserDao = corporateUserDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateCorporateUserRequest createCorporateUserRequest) throws BusinessException {
		
		checkIfEmailExists(createCorporateUserRequest.getEmail());
		CorporateUser corporateUser = this.modelMapperService.forRequest()
				.map(createCorporateUserRequest, CorporateUser.class);
		this.corporateUserDao.save(corporateUser);
		
		return new SuccessResult(Messages.ADDED);
		
	}

	@Override
	public DataResult<List<ListCorporateUserDto>> getAll() {
		
		var result = this.corporateUserDao.findAll();
		List<ListCorporateUserDto> response = result.stream()
				.map(corporateUser -> this.modelMapperService.forDto()
						.map(corporateUser, ListCorporateUserDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCorporateUserDto>>(response);
		
	}

	@Override
	public DataResult<ListCorporateUserDto> getById(int corporateUserId) throws BusinessException {
		
		CorporateUser result = checkIfCorporateUserIdExists(corporateUserId);
		ListCorporateUserDto response = this.modelMapperService.forDto()
				.map(result, ListCorporateUserDto.class);
		
		return new SuccessDataResult<ListCorporateUserDto>(response);
		
	}

	@Override
	public Result delete(DeleteCorporateUserRequest deleteCorporateUserRequest) throws BusinessException {
		
		CorporateUser corporateUser = checkIfCorporateUserIdExists(deleteCorporateUserRequest.getCorporateUserId());
		this.corporateUserDao.delete(corporateUser);
		
		return new SuccessResult(Messages.DELETED);
		
	}

	@Override
	public Result update(UpdateCorporateUserRequest updateCorporateUserRequest) throws BusinessException {
		
		checkIfCorporateUserIdExists(updateCorporateUserRequest.getCorporateUserId());
		
		CorporateUser corporateUser = this.modelMapperService.forRequest()
				.map(updateCorporateUserRequest, CorporateUser.class);
		this.corporateUserDao.save(corporateUser);
		
		return new SuccessResult(Messages.UPDATED);
		
	}
	
	private CorporateUser checkIfCorporateUserIdExists(int corporateUserId) throws BusinessException{
		
		CorporateUser result = this.corporateUserDao.getByCorporateUserId(corporateUserId);
		if(result == null) {
			throw new BusinessException(Messages.NOTFOUND);
		}
		return result;
		
	}
	
	private boolean checkIfEmailExists(String email) throws BusinessException{
		
		CorporateUser corporateUser = this.corporateUserDao.findByEmail(email);
		if(corporateUser != null) {
			throw new BusinessException(Messages.EXISTS);
		}
		return true;
		
	}
	
}
