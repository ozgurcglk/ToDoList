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

import com.appcent.todolist.business.abstracts.OnGoingTaskService;
import com.appcent.todolist.business.dtos.ListOnGoingTaskDto;
import com.appcent.todolist.business.requests.OnGoingTaskRequests.CreateOnGoingTaskRequest;
import com.appcent.todolist.business.requests.OnGoingTaskRequests.DeleteOnGoingTaskRequest;
import com.appcent.todolist.business.requests.OnGoingTaskRequests.UpdateOnGoingTaskRequest;
import com.appcent.todolist.core.concretes.BusinessException;
import com.appcent.todolist.core.results.DataResult;
import com.appcent.todolist.core.results.Result;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/onGoingTasks")
public class OnGoingTaskControllers {

	private OnGoingTaskService onGoingTaskService;
	
	@Autowired
	public OnGoingTaskControllers(OnGoingTaskService onGoingTaskService) {
		this.onGoingTaskService = onGoingTaskService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateOnGoingTaskRequest createOnGoingTaskRequest) throws BusinessException{
		return this.onGoingTaskService.add(createOnGoingTaskRequest);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ListOnGoingTaskDto>> getAll(){
		return this.onGoingTaskService.getAll();
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteOnGoingTaskRequest deleteOnGoingTaskRequest) throws BusinessException{
		return this.onGoingTaskService.delete(deleteOnGoingTaskRequest);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdateOnGoingTaskRequest updateOnGoingTaskRequest) throws BusinessException{
		return this.onGoingTaskService.update(updateOnGoingTaskRequest);
	}
	
}
