package com.appcent.todolist.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appcent.todolist.business.abstracts.CorporateUserService;
import com.appcent.todolist.business.dtos.ListCorporateUserDto;
import com.appcent.todolist.business.requests.CorporateUserRequests.CreateCorporateUserRequest;
import com.appcent.todolist.business.requests.CorporateUserRequests.DeleteCorporateUserRequest;
import com.appcent.todolist.business.requests.CorporateUserRequests.UpdateCorporateUserRequest;
import com.appcent.todolist.core.concretes.BusinessException;
import com.appcent.todolist.core.results.DataResult;
import com.appcent.todolist.core.results.Result;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/corporateUsers")
public class CorporateUserControllers {
	
	private CorporateUserService corporateUserService;

	@Autowired
	public CorporateUserControllers(CorporateUserService corporateUserService) {
		this.corporateUserService = corporateUserService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateCorporateUserRequest createCorporateUserRequest) throws BusinessException{
		return this.corporateUserService.add(createCorporateUserRequest);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ListCorporateUserDto>> getAll(){
		return this.corporateUserService.getAll();
	}
	
	@GetMapping("/getByCorporateUserId")
	public DataResult<ListCorporateUserDto> getById(@RequestParam int corporateUserId) throws BusinessException{
		return this.corporateUserService.getById(corporateUserId);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdateCorporateUserRequest updateCorporateUserRequest) throws BusinessException{
		return this.corporateUserService.update(updateCorporateUserRequest);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteCorporateUserRequest deleteCorporateUserRequest) throws BusinessException{
		return this.corporateUserService.delete(deleteCorporateUserRequest);
	}
	
}
