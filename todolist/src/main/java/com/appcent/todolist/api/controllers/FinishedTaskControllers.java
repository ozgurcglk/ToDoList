package com.appcent.todolist.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appcent.todolist.business.abstracts.FinishedTaskService;
import com.appcent.todolist.business.dtos.ListFinishedTaskDto;
import com.appcent.todolist.business.requests.FinishedTaskRequests.CreateFinishedTaskRequest;
import com.appcent.todolist.business.requests.FinishedTaskRequests.DeleteFinishedTaskRequest;
import com.appcent.todolist.business.requests.FinishedTaskRequests.UpdateFinishedTaskRequest;
import com.appcent.todolist.core.concretes.BusinessException;
import com.appcent.todolist.core.results.DataResult;
import com.appcent.todolist.core.results.Result;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/finishedTasks")
public class FinishedTaskControllers {
	
	private FinishedTaskService finishedTaskService;

	@Autowired
	public FinishedTaskControllers(FinishedTaskService finishedTaskService) {		
		this.finishedTaskService = finishedTaskService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateFinishedTaskRequest createFinishedTaskRequest) throws BusinessException{
		return this.finishedTaskService.add(createFinishedTaskRequest);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ListFinishedTaskDto>> getAll(){
		return this.finishedTaskService.getAll();
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdateFinishedTaskRequest updateFinishedTaskRequest) throws BusinessException{
		return this.update(updateFinishedTaskRequest);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteFinishedTaskRequest deleteFinishedTaskRequest) throws BusinessException{
		return this.finishedTaskService.delete(deleteFinishedTaskRequest);
	}
	
}
