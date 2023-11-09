package com.exercise.tasksmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @Enumerated(EnumType.STRING)
    private TaskGroup taskGroup;
    private String assignee;

    @ManyToMany
    @JoinTable(name = "task_subtask",
               joinColumns = @JoinColumn(name = "task_id"),
               inverseJoinColumns = @JoinColumn(name = "subtask_id"),
               uniqueConstraints = @UniqueConstraint(columnNames = {
                    "task_id", "subtask_id" }))
    private List<SubTask> subTasks;
}
