package com.exercise.tasksmanagementsystem.service;

import com.exercise.tasksmanagementsystem.dto.TaskDto;
import com.exercise.tasksmanagementsystem.entity.Task;
import com.exercise.tasksmanagementsystem.exception.ResourceNotFoundException;
import com.exercise.tasksmanagementsystem.mapper.TaskMapper;
import com.exercise.tasksmanagementsystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    public TaskDto save(TaskDto taskDto){
        Task task = taskMapper.toEntity(taskDto);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toDto(savedTask);
    }

    public List<TaskDto> findAll(){
        List<Task> tasks = taskRepository.findAll();
        return taskMapper.toDtoList(tasks);
//        return taskRepository.findAll()
//                .stream()
//                .map(taskMapper::toDto)
//                .collect(Collectors.toList());
    }

    public TaskDto findById(Long taskId){
        Task task = taskRepository.findById(taskId)
                .orElseThrow(()-> new ResourceNotFoundException("Task not found with id: " + taskId));
        return taskMapper.toDto(task);
    }

    public TaskDto updateTask(Long taskId, TaskDto updatedTaskDto) {
        Task existingTask = taskRepository.findById(taskId)
                .orElseThrow(()-> new ResourceNotFoundException("Task not found with id: " + taskId));
        taskMapper.updateEntityFromDto(existingTask,updatedTaskDto);
        Task updatedTask = taskRepository.save(existingTask);
        return taskMapper.toDto(updatedTask);
    }

    public void deleteTask(Long taskId){
        Task task = taskRepository.findById(taskId)
                .orElseThrow(()-> new ResourceNotFoundException("Task not found with id: " + taskId));
        taskRepository.delete(task);
    }
}
