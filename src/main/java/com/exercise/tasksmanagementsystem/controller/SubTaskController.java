package com.exercise.tasksmanagementsystem.controller;

import com.exercise.tasksmanagementsystem.dto.SubTaskDto;
import com.exercise.tasksmanagementsystem.service.SubTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/subtask")
public class SubTaskController {

    private final SubTaskService subTaskService;

    @GetMapping("/{id}")
    public ResponseEntity<SubTaskDto> findSubTaskById(@PathVariable Long id){
        SubTaskDto subTaskDto = subTaskService.findById(id);
        return ResponseEntity.ok(subTaskDto);
    }

    @GetMapping("/{id}/parentTaskIds")
    public ResponseEntity<List<Long>> getParentTaskIds(@PathVariable Long id) {
        List<Long> parentTaskIds = subTaskService.getParentTaskIds(id);
        if (parentTaskIds != null) {
            return new ResponseEntity<>(parentTaskIds, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
