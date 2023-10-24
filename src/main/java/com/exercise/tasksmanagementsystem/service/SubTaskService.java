package com.exercise.tasksmanagementsystem.service;

import com.exercise.tasksmanagementsystem.dto.SubTaskDto;
import com.exercise.tasksmanagementsystem.entity.SubTask;
import com.exercise.tasksmanagementsystem.entity.Task;
import com.exercise.tasksmanagementsystem.exception.ResourceNotFoundException;
import com.exercise.tasksmanagementsystem.mapper.SubTaskMapper;
import com.exercise.tasksmanagementsystem.repository.SubTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SubTaskService {

    private final SubTaskRepository subTaskRepository;

    private final SubTaskMapper subTaskMapper;

    public SubTaskDto findById(Long id){
        SubTask subTask = subTaskRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Task not found with id: " + id));
        return subTaskMapper.toDto(subTask);
    }


    public List<Long> getParentTaskIds(Long subTaskId) {
        SubTask subTask = subTaskRepository.findById(subTaskId).orElse(null);

        if (subTask != null) {
            List<Task> parentTasks = subTask.getParentTasks();
            return parentTasks.stream()
                    .map(Task::getId)
                    .collect(Collectors.toList());
        } else {
            return List.of(); // Return an empty list if the subtask doesn't exist
        }
    }

}
