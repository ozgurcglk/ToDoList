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

import com.appcent.todolist.business.abstracts.TaskService;
import com.appcent.todolist.business.dtos.ListTaskDto;
import com.appcent.todolist.business.requests.TaskRequests.CreateTaskRequest;
import com.appcent.todolist.business.requests.TaskRequests.DeleteTaskRequest;
import com.appcent.todolist.business.requests.TaskRequests.UpdateTaskRequest;
import com.appcent.todolist.core.concretes.BusinessException;
import com.appcent.todolist.core.results.DataResult;
import com.appcent.todolist.core.results.Result;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/tasks")
public class TaskControllers {
	
	private TaskService taskService;
	
	@Autowired
	public TaskControllers(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateTaskRequest createTaskRequest) throws BusinessException{
		return this.taskService.add(createTaskRequest);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ListTaskDto>> getAll(){
		return this.taskService.getAll();
	}
	
	@GetMapping("/getByTaskId")
	public DataResult<ListTaskDto> getById(@RequestParam @Valid int taskId) throws BusinessException{
		return this.taskService.getById(taskId);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdateTaskRequest updateTaskRequest) throws BusinessException{
		return this.taskService.update(updateTaskRequest);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteTaskRequest deleteTaskRequest) throws BusinessException{
		return this.taskService.delete(deleteTaskRequest);
	}
	
	
}
