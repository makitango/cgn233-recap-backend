package com.example.cgn233recapbackend;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        Task createdTask = new Task(
                task.id(),
                task.description(),
                task.status()
        );
        return taskRepository.save(createdTask);
    }
}
