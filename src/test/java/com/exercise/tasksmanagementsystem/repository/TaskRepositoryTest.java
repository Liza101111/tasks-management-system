package com.exercise.tasksmanagementsystem.repository;
import com.exercise.tasksmanagementsystem.entity.Task;
import com.exercise.tasksmanagementsystem.entity.TaskGroup;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest
class TaskRepositoryTest {
    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testSaveTask(){
        //Given
        Task task = new Task(
                1L,
                "Lucy",
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(30),
                TaskGroup.TASK_UNITY,
                "Boss1"
        );

        //When
        Task savedTask = taskRepository.save(task);

        //Then
        Assertions.assertThat(savedTask).isNotNull();
        Assertions.assertThat(savedTask.getId()).isGreaterThan(0);
    }

}