package com.exercise.tasksmanagementsystem.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    @Enumerated(EnumType.STRING)
    private TaskGroup group;
    private String assignee;
}
