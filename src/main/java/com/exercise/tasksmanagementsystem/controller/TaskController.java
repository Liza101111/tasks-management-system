package com.exercise.tasksmanagementsystem.controller;

import com.exercise.tasksmanagementsystem.entity.Task;
import com.exercise.tasksmanagementsystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/save")
    public ResponseEntity<Task> saveTask(@RequestBody Task task){
        Task savedTask = taskRepository.save(task);
        return new ResponseEntity<>(savedTask, HttpStatus.OK);
    }

}
