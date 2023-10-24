package com.exercise.tasksmanagementsystem.repository;

import com.exercise.tasksmanagementsystem.entity.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
}
