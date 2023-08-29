package com.exercise.tasksmanagementsystem.mapper;

import com.exercise.tasksmanagementsystem.dto.TaskDto;
import com.exercise.tasksmanagementsystem.entity.Task;
import com.exercise.tasksmanagementsystem.entity.TaskGroup;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskDto toDto(Task task) {
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setName(task.getName());
        dto.setStartDate(task.getStartDate());
        dto.setEndDate(task.getEndDate());
        dto.setTaskGroup(task.getTaskGroup().name());
        dto.setAssignee(task.getAssignee());
        return dto;
    }

    public Task toEntity(TaskDto dto) {
        Task task = new Task();
        task.setId(dto.getId());
        task.setName(dto.getName());
        task.setStartDate(dto.getStartDate());
        task.setEndDate(dto.getEndDate());
        task.setTaskGroup(TaskGroup.valueOf(dto.getTaskGroup()));
        task.setAssignee(dto.getAssignee());
        return task;
    }
}
