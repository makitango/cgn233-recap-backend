package com.example.cgn233recapbackend;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task postTask(Task task) {
        Task createdTask = new Task(
                UUID.randomUUID().toString(),
                task.description(),
                TaskStatus.OPEN
        );
        return taskRepository.save(createdTask);
    }

    public Task putTask(Task task) {
        return taskRepository.save(task);
    }
}
