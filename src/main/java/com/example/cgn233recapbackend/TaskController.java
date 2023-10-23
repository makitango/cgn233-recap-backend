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
    @GetMapping("/{id}")
    public Task getTask(@PathVariable String id, Task task) {
        System.out.println("Detail view or edit task id " + task.description());
        return taskService.getTask(id);
    }

    @PostMapping
    public Task postTask(@RequestBody Task task) {
        System.out.println("Created task " + task);
        return taskService.postTask(task);
    }

    @PutMapping("/{id}")
    public Task moveTask(@RequestBody Task task) {
        System.out.println("Moved task " + task);
        return taskService.moveTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        System.out.println("Deleted task with the id " + id);

        taskService.deleteTask(id);
    }
}
