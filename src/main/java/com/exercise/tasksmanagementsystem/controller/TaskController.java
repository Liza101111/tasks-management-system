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
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDto> saveTask(@RequestBody TaskDto taskDto){

        return ResponseEntity.ok().body(taskService.save(taskDto));
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks(){

        return ResponseEntity.ok().body(taskService.findAll());
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long taskId) {
        TaskDto taskDto = taskService.findById(taskId);
        return ResponseEntity.ok(taskDto);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Long taskId, @RequestBody TaskDto updatedTaskDto){
        TaskDto updatedTask = taskService.updateTask(taskId,updatedTaskDto);
        return ResponseEntity.ok(updatedTask);
    }

}
