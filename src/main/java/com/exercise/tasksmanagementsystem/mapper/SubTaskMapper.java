package com.exercise.tasksmanagementsystem.mapper;

import com.exercise.tasksmanagementsystem.dto.SubTaskDto;
import com.exercise.tasksmanagementsystem.entity.SubTask;
import com.exercise.tasksmanagementsystem.entity.Task;
import com.exercise.tasksmanagementsystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class SubTaskMapper {

    @Autowired
    private TaskRepository taskRepository;

    public SubTaskDto toDto(SubTask subTask) {
        SubTaskDto subTaskDto = new SubTaskDto();
        subTaskDto.setId(subTask.getId());
        subTaskDto.setName(subTask.getName());

        List<Long> parentTaskIds = subTask.getParentTasks().stream()
                .map(Task::getId)
                .collect(Collectors.toList());
        subTaskDto.setParentTaskIds(parentTaskIds);

        return subTaskDto;
    }

    public SubTask toEntity(SubTaskDto subTaskDto) {
        SubTask subTask = new SubTask();
        subTask.setId(subTaskDto.getId());
        subTask.setName(subTaskDto.getName());

        if (subTaskDto.getParentTaskIds() != null) {
            List<Task> parentTasks = subTaskDto.getParentTaskIds().stream()
                    .map(taskId -> taskRepository.findById(taskId).orElse(null))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            subTask.setParentTasks(parentTasks);
        } else {
            subTask.setParentTasks(new ArrayList<>());
        }

        return subTask;
    }
}
