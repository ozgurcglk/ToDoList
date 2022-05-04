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

import com.appcent.todolist.business.abstracts.IndividualUserService;
import com.appcent.todolist.business.dtos.ListIndividualUserDto;
import com.appcent.todolist.business.requests.IndividualUserRequests.CreateIndividualUserRequest;
import com.appcent.todolist.business.requests.IndividualUserRequests.DeleteIndividualUserRequest;
import com.appcent.todolist.business.requests.IndividualUserRequests.UpdateIndividualUserRequest;
import com.appcent.todolist.core.concretes.BusinessException;
import com.appcent.todolist.core.results.DataResult;
import com.appcent.todolist.core.results.Result;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/individualUsers")
public class IndividualUserControllers {
	
	private IndividualUserService individualUserService;

	@Autowired
	public IndividualUserControllers(IndividualUserService individualUserService) {
		this.individualUserService = individualUserService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateIndividualUserRequest createIndividualUserRequest) throws BusinessException{
		return this.individualUserService.add(createIndividualUserRequest);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ListIndividualUserDto>> getAll(){
		return this.individualUserService.getAll();
	}
	
	@GetMapping("/getByIndividualUserId")
	public DataResult<ListIndividualUserDto> getById(@RequestParam @Valid int individualUserId) throws BusinessException{
		return this.individualUserService.getById(individualUserId);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdateIndividualUserRequest updateIndividualUserRequest) throws BusinessException{
		return this.individualUserService.update(updateIndividualUserRequest);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteIndividualUserRequest deleteIndividualUserRequest) throws BusinessException{
		return this.individualUserService.delete(deleteIndividualUserRequest);
	}
	
	
}
