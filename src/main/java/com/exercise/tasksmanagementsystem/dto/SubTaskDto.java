package com.exercise.tasksmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubTaskDto {

    private Long id;
    private String name;
    private List<Long> parentTaskIds;
}
