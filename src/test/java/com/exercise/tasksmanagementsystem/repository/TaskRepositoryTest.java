package com.exercise.tasksmanagementsystem.repository;
import com.exercise.tasksmanagementsystem.entity.Task;
import com.exercise.tasksmanagementsystem.entity.TaskGroup;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    @Test
    public void testFindAll(){
        Task task1 = new Task(
                2L,
                "Lucy",
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(30),
                TaskGroup.TASK_UNITY,
                "Boss1"
        );
        Task task2 = new Task(
                3L,
                "Liza",
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(100),
                TaskGroup.TASK_FUSION,
                "Boss2"
        );

        taskRepository.save(task1);
        taskRepository.save(task2);

        List<Task> taskList = taskRepository.findAll();

        Assertions.assertThat(taskList.size()).isEqualTo(2);
        for(Task task: taskList){
            System.out.println(task);
        }
    }

    @Test
    public void testFindById(){
        Task task = new Task(
                4L,
                "Lucy",
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(30),
                TaskGroup.TASK_UNITY,
                "Boss1"
        );

        taskRepository.save(task);

        Optional<Task> optionalTask= taskRepository.findById(4L);

        Assertions.assertThat(optionalTask).isNotNull();
    }

}