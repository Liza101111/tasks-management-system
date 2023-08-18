package com.exercise.tasksmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int timeSpent;
    @Enumerated(EnumType.STRING)
    private TaskGroup group;
    private String assignee;
}
