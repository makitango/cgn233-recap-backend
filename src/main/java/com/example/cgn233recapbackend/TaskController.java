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
    public Task putTask(@PathVariable String id, @RequestBody Task task) {
        if (!id.equals(task.id())) {
            throw new IllegalArgumentException("id does not match");
        }
        return taskService.putTask(task);
    }
}
