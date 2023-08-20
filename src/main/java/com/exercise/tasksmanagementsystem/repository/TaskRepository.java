package com.exercise.tasksmanagementsystem.repository;

import com.exercise.tasksmanagementsystem.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TaskRepository extends JpaRepository<Task, Long> {
}
