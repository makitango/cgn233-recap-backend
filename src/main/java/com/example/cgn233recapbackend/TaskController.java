package com.example.cgn233recapbackend;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService todoService) {
        this.taskService = todoService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return this.taskService.getAllTasks();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        System.out.println(task);
        return taskService.createTask(task);
    }
}