package com.exercise.tasksmanagementsystem.controller;

import com.exercise.tasksmanagementsystem.dto.TaskDto;
import com.exercise.tasksmanagementsystem.entity.Task;
import com.exercise.tasksmanagementsystem.repository.TaskRepository;
import com.exercise.tasksmanagementsystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/task")
    public ResponseEntity<TaskDto> saveTask(@RequestBody TaskDto taskDto){

        return ResponseEntity.ok().body(taskService.save(taskDto));
    }

    @GetMapping("/task")
    public ResponseEntity<List<TaskDto>> getAllTasks(){

        return ResponseEntity.ok().body(taskService.findAll());
    }

}
