package com.exercise.tasksmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean finished;
}
