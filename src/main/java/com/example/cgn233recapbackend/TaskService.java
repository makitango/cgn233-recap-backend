package com.example.cgn233recapbackend;

import org.springframework.stereotype.Service;

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

    public Task getTask(String id) {
        return taskRepository.findById(id).orElseThrow();
    }

    public Task postTask(Task task) {
        Task createdTask = new Task(
                UUID.randomUUID().toString(),
                task.description(),
                TaskStatus.OPEN
        );
        return taskRepository.save(createdTask);
    }

    public Task moveTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }
}
