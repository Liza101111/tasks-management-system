package com.exercise.tasksmanagementsystem.mapper;

import com.exercise.tasksmanagementsystem.dto.TaskDto;
import com.exercise.tasksmanagementsystem.entity.SubTask;
import com.exercise.tasksmanagementsystem.entity.Task;
import com.exercise.tasksmanagementsystem.entity.TaskGroup;
import com.exercise.tasksmanagementsystem.repository.SubTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class TaskMapper {

    @Autowired
    private SubTaskRepository subTaskRepository;

    public TaskDto toDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setName(task.getName());
        taskDto.setTaskGroup(task.getTaskGroup().name());
        taskDto.setAssignee(task.getAssignee());

        List<Long> subTaskIds = task.getSubTasks().stream()
                .map(SubTask::getId)
                .collect(Collectors.toList());
        taskDto.setSubTaskIds(subTaskIds);

        return taskDto;
    }

    public Task toEntity(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setName(taskDto.getName());
        task.setTaskGroup(TaskGroup.valueOf(taskDto.getTaskGroup()));
        task.setAssignee(taskDto.getAssignee());

        if (taskDto.getSubTaskIds() != null) {
            List<SubTask> subTasks = taskDto.getSubTaskIds().stream()
                    .map(subTaskId -> subTaskRepository.findById(subTaskId).orElse(null))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            task.setSubTasks(subTasks);
        } else {
            task.setSubTasks(new ArrayList<>());
        }

        return task;
    }

    public List<TaskDto> toDtoList(List<Task> tasks){
        List<TaskDto> taskDtoList = new ArrayList<>();
        for(Task task: tasks){
            taskDtoList.add(toDto(task));
        }
        return taskDtoList;
    }

   /* public List<Task> toEntityList(List<TaskDto> taskDtos) {
        List<Task> taskList = new ArrayList<>();
        for(TaskDto taskDto: taskDtos){
            taskList.add(toEntity(taskDto));
        }
        return taskList;
    }*/

    public void updateEntityFromDto(Task task, TaskDto taskDto){
        task.setId(taskDto.getId());
        task.setName(taskDto.getName());
        task.setTaskGroup(TaskGroup.valueOf(taskDto.getTaskGroup()));
        task.setAssignee(taskDto.getAssignee());
    }

}
