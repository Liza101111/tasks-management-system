package com.exercise.tasksmanagementsystem.mapper;

import com.exercise.tasksmanagementsystem.dto.TaskDto;
import com.exercise.tasksmanagementsystem.entity.Task;
import com.exercise.tasksmanagementsystem.entity.TaskGroup;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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
    public List<TaskDto> toDtoList(List<Task> tasks){
        List<TaskDto> taskDtoList = new ArrayList<>();
        for(Task task: tasks){
            taskDtoList.add(toDto(task));
        }
        return taskDtoList;
    }

    public List<Task> toEntityList(List<TaskDto> taskDtos) {
        List<Task> taskList = new ArrayList<>();
        for(TaskDto taskDto: taskDtos){
            taskList.add(toEntity(taskDto));
        }
        return taskList;
    }

    public void updateEntityFromDto(Task task, TaskDto taskDto){
        task.setId(taskDto.getId());
        task.setName(taskDto.getName());
        task.setStartDate(taskDto.getStartDate());
        task.setEndDate(taskDto.getEndDate());
        task.setTaskGroup(TaskGroup.valueOf(taskDto.getTaskGroup()));
        task.setAssignee(taskDto.getAssignee());
    }

}
