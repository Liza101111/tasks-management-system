package com.exercise.tasksmanagementsystem.service;

import com.exercise.tasksmanagementsystem.dto.TaskDto;
import com.exercise.tasksmanagementsystem.entity.Task;
import com.exercise.tasksmanagementsystem.mapper.TaskMapper;
import com.exercise.tasksmanagementsystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    public TaskDto save(TaskDto taskDto){
        Task task = taskMapper.toEntity(taskDto);
        task = taskRepository.save(task);
        return taskMapper.toDto(task);
    }
}
