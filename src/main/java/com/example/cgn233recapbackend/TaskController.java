package com.example.cgn233recapbackend;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks() {
        return this.taskService.getTasks();
    }

    @PostMapping
    public Task postTask(@RequestBody Task task) {
        System.out.println(task);
        return taskService.postTask(task);
    }

    @PutMapping("/{id}")
    public Task putTask(@RequestBody Task task) {
        System.out.println(task);
        return taskService.putTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
    }
}
